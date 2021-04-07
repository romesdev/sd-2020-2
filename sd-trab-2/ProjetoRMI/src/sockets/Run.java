package sockets;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;

public class Run {
	
private static Servidor servidor = null;
	
	public static void main(String[] args) {
		
		int porta = 1928;
		
		try {
			createServer(porta);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
		
	}
		

	
	private static void createServer(int porta) throws SocketException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		servidor = new Servidor(porta);
		servidor.run(300);
	}


}
