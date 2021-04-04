package sockets;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;

public class Run {
	
private static Servidor servidor = null;
	
	public static void main(String[] args) {
		
		
		
		try {
			createServer(Integer.valueOf(args[0]));
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("porta definida: " + Constants.SERVER_PORT);
			main(new String[] {
					String.valueOf(Constants.SERVER_PORT)
				});
		} catch (IllegalAccessException e) {
			System.out.println("digite uma porta valida (inteiro)");
			
		} 
		
		
		
		

	}
	
	private static void createServer(int porta) throws SocketException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		servidor = new Servidor(porta);
		servidor.listener(500);
	}


}
