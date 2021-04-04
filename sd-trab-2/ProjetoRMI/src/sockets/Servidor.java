package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.sun.jdi.Method;


public class Servidor{

	
	private InetAddress lastClientIp;
	private int lastClientPort;
	private DatagramSocket socket;// controla o socket nessa implementação
	
	
	public Servidor(int serverPort) throws SocketException {
		System.out.println("Servidor iniciado na porta " + serverPort);
		this.socket = new DatagramSocket(serverPort);
				
	}
	
	//pega as requisições (método previsto pelo autor, George Coulouris)
	public byte[] getRequisicao() {
		byte[] buffer = new byte[Constants.BUFFER_SIZE];
		DatagramPacket request = new DatagramPacket(
				buffer,
				Constants.BUFFER_SIZE
			);
		
		try {
			this.socket.receive(request);
			this.lastClientIp = request.getAddress();
			this.lastClientPort = request.getPort();
			return request.getData();
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return null;
		}
				
	}
	
	//envia respostas (método previsto pelo autor, George Coulouris)
	public void sendReply(byte[] respostaBytes) {
		DatagramPacket resposta = new DatagramPacket(
				respostaBytes,
				0,
				respostaBytes.length,
				lastClientIp,
				lastClientPort);
		try {
			System.out.println("Mandando resposta para " + lastClientIp + ":" + lastClientPort);
			socket.send(resposta);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	
	}
	
	
	//esperando comunicação
	public void listener(long delay) throws InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Escutando a cada " + delay + "ms...");
		while(true) {
			Thread.sleep(delay);
			
			byte[] requisicao = getRequisicao();
			if(requisicao == null)
				continue;
			
			MensagemRequisicao mensagem = MensagemRequisicao.deBytes(requisicao);
			
			
			System.out.println("Argumento recebido de " + lastClientIp.toString());
					
			if(mensagem.getRemoteObjectRef().getmInterface().equals(Pacote.class)) {
				
				
				
				MensagemRequisicao resposta = new MensagemRequisicao(mensagem.getMethodId(), mensagem.getArgs());
				
				for(java.lang.reflect.Method m : mensagem.getRemoteObjectRef().getmInterface().getDeclaredMethods()) {
					System.out.print(m.getName() + " | id=" + m.hashCode());
					if(m.hashCode() == mensagem.getMethodId() ) {
						System.out.println("  id do método invocado" );
						Object[] args = mensagem.getObjectsArgs();
						
						Pacote pacote = new Pacote();
						m.invoke(pacote, args);
						
						
						
					}
					System.out.print("\n");
							
					
				}
				
				sendReply(resposta.toBytes());
				
			} else {
				System.out.println(mensagem.getRemoteObjectRef().getmInterface().toString());
			}	
			
			
		}
					
		
		
	}
	

}


