package sockets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.jdi.Method;

public class Cliente {

private int serverPort;
	
	private Pacote pacote;//mensagem para a transmissao
	
	
	
	/**
	 * @param message
	 */
	public Cliente(Pacote p, int serverPort) {
		super();
		this.pacote = p;
		this.serverPort = serverPort;
	}
	
	private java.lang.reflect.Method getMethod(String methodName, java.lang.reflect.Method[] methods) {
		for(java.lang.reflect.Method m : methods) {
			if(m.getName().equals(methodName)) {
				return m;
				
			}	
						
		}
		
		return null;
	}

	//realiza a operacao de transmissao de mensagens
	public void doOperation(String methodName, String[] args) throws IOException, NoSuchMethodException {
		System.out.println("Requisição\n"+"Começo da operação...");
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Objeto remoto
		Class<?> obj = null;
		obj = pacote.getClass();
			
		
		
		
		
		
		RemoteObjectReference ref = new RemoteObjectReference(
				ip,
				this.serverPort,
				obj.hashCode(),
				0,
				obj);

		
		
		
		
		
		java.lang.reflect.Method m = getMethod(methodName, obj.getMethods());
		
		if(m == null)
			throw new NoSuchMethodException();
		
		int id = m.hashCode();
		
		
		
		MensagemRequisicao request = new MensagemRequisicao(ref, id, args);
		
		DatagramPacket packet = new DatagramPacket(request.toBytes(), 0, request.toBytes().length, ip, serverPort);
		
	
		DatagramSocket socket = new DatagramSocket();
		
		socket.send(packet);
		
		byte[] buffer = new byte[Constants.BUFFER_SIZE];
		
		DatagramPacket response = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(response);
		System.out.println("\nO que foi recebido:\n");
		
		byte[] result = response.getData();
		
		System.out.println(MensagemRequisicao.deBytes(result).toString());
		
		
		socket.close();
		
	}
}
