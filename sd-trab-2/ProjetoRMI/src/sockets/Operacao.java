package sockets;

import java.io.IOException;

public class Operacao {
	private static Pacote pacote;
	private static Cliente cliente;

	public static void main(String[] args) {
		
		String porta = "1928";
		
		
				try {
					fazerOperacao(porta,
							"metodo2",//ou pode ser passado o "metodo1"
							"MensagemTESTEE");
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		

	}
	
	private static void fazerOperacao(String porta, String metodo, String argumentos) throws NoSuchMethodException, IOException {
		pacote = new Pacote();// pacote já foi criado em cima na classe
		
		cliente = new Cliente(pacote, Integer.valueOf(porta)); // cliente já foi criado em cima na classe
		
		
		String[] args = null;
		 
		// Method 1 :: using String.split() method
		args = argumentos.split(" "); 
		
				
		cliente.doOperation(metodo,  args); //(método previsto pelo autor, George Coulouris)
	}
	
}
