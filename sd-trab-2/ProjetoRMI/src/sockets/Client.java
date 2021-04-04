package sockets;

import java.io.IOException;

public class Client {
	private static Pacote pacote;
	private static Cliente cliente;

	public static void main(String[] args) {
		
		
		
		
		try {
			if(args.length > 1)
				createCliente(args);
			else {
				System.out.println("qualquer coisa só para começar a testar");
				String port = "";
				if(args.length == 0) {
					port = String.valueOf(Constants.SERVER_PORT);
				} else {
					port = args[0];
				}
					
				
				main(new String[] {
						port,
						"metodo2",
						"MensagemTESTEE"
				});
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("método "  + args[1] + " não existe");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		

	}
	
	private static void createCliente(String[] args) throws NoSuchMethodException, IOException {
		pacote = new Pacote();
		
		String port = args[0];
		
		if(!port.matches("^[0-9]*$")) {
			port = String.valueOf(Constants.SERVER_PORT);
		}
		
		cliente = new Cliente(pacote, Integer.valueOf(port));
		
		String[] arguments = new String[args.length-2];
					
		
		for(int i = 0; i < arguments.length; i++) 
			arguments[i] = args[i+2];
		
				
		cliente.doOperation(args[1],  arguments);
	}
	
}
