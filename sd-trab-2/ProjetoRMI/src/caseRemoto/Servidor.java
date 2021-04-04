package caseRemoto;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Servidor extends UnicastRemoteObject implements InterfaceRemota {
    @Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public Servidor() throws RemoteException {}

    public String metodoRemoto1(String end) throws RemoteException{
    	
    	String str = "nadinha aqui";
        
        Pessoa pessoa;
        try{
        	FileInputStream fin = new FileInputStream(end);

		   ObjectInputStream ois = new ObjectInputStream(fin);
		   
		   pessoa = (Pessoa) ois.readObject();
		   ois.close();
        
		   str = pessoa.imprimir();
		   System.out.println("Feito aqui");
        }catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	
    	return str;


    }
    public String metodoRemoto2(String end) throws RemoteException {
        String str = "nadinha aqui";
        
        Carro carro;
        try{
        	FileInputStream fin = new FileInputStream(end);

		   ObjectInputStream ois = new ObjectInputStream(fin);

		   carro = (Carro) ois.readObject();
		   ois.close();
        
		   str = carro.imprimir();
		   System.out.println("Feito aqui");
        }catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	
    	return str;
    }
    public String metodoRemoto3(String end) throws RemoteException {
        String str = "nadinha aqui";
        
        Motorista motorista;
        try{
        FileInputStream fin = new FileInputStream(end);

		   ObjectInputStream ois = new ObjectInputStream(fin);

		   motorista = (Motorista) ois.readObject();
		   ois.close();
        
		   str = motorista.imprimir();
		   System.out.println("Feito aqui");
        }catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	
    	return str;
    }
    
    
    public String metodoRemoto4(String end) throws RemoteException {
        String str = "nadinha aqui";
        
        Caneta caneta;
        try{
        FileInputStream fin = new FileInputStream(end);

		   ObjectInputStream ois = new ObjectInputStream(fin);

		   caneta = (Caneta) ois.readObject();
		   ois.close();
        
		   str = caneta.imprimir();
		   System.out.println("Feito aqui");
        
        }catch(Exception ex){
 		   ex.printStackTrace();
        }
    	
    	return str;
    }
    
    
       
        
    public static void main(String args[]) {
        
        try {
            Servidor obj = new Servidor();
            //Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            //System.setProperty("java.rmi.server.useLocalHostname=true","192.168.2.108");
          //Resolve o registro
            int port = 1029;
            Registry registry;
            
            
            try {
            	registry = LocateRegistry.createRegistry(port);
                registry.bind("InterfaceRemota", obj);
                System.err.println("SERVIDOR PRONTO");



            } catch (RemoteException e) {
                try {
                	registry = LocateRegistry.getRegistry(port);
                    registry.rebind("InterfaceRemota", obj);
                    System.err.println("SERVIDOR PRONTO");


                } catch (RemoteException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }


        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}