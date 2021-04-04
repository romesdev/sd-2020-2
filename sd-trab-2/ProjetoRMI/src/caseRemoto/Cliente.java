package caseRemoto;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    private Cliente() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
        	//System.setProperty( "java.rmi.server.hostname", "192.168.2.108" );
            
        	String porta = "1029";//porta escolhida para o acesso
        	Registry registry = LocateRegistry.getRegistry(host);
            System.out.println(registry.toString());
            InterfaceRemota stub = (InterfaceRemota) Naming.lookup("//localhost:"+ porta+"/InterfaceRemota");
            
            
            //uso dos 4 objetos (do tipo POJO)
            String end1 = usandoPessoa();
            String metodo1 = stub.metodoRemoto1(end1);        
               
            String end2 = usandoCarro();
    		String metodo2 = stub.metodoRemoto2(end2);
    		
            String end3 = usandoMotorista();
    		String metodo3 = stub.metodoRemoto3(end3);
    		
            String end4 = usandoCaneta();
    		String metodo4 = stub.metodoRemoto4(end4);            
            
    		//resultados das chamadas com o servidor
            System.out.println("método 1: " + metodo1);
            System.out.println("método 2: " + metodo2);
            System.out.println("método 3: " + metodo3);
            System.out.println("método 4: " + metodo4);




        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    
    
    public static String usandoPessoa() {
    	String end = "";
    	
    	Carro c1 = new Carro("pasd-123", "Aston Martin");
    	Carro c2 = new Carro("rrrr-111", "Ford");
    	Carro c3 = new Carro("aaaa-222", "Maserati");

    	Pessoa p1 = new Pessoa("Casemiro", "1234", 30, c1);
    	Pessoa p2 = new Pessoa("Lana", "234", 59, c2);
    	Pessoa p3 = new Pessoa("Maria", "444", 20, c3);
    	//Motorista p4 = new Motorista("Maria", "444", 20, c3, "000124");
   
    	p1.adicionar(p2);
    	p1.adicionar(p3);
    	p1.adicionar(p1);
    	
    	try {
    		end = "\\pessoa.ser";
    		FileOutputStream fout = new FileOutputStream(end);
    		ObjectOutputStream oos = new ObjectOutputStream(fout);
    		oos.writeObject(p1);
    		oos.close();
    		System.out.println("Done");
            
    	}catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	    	
    	return end;
    }
    
    public static String usandoCarro() {
    	String end = "";
    	
    	Carro c1 = new Carro("pasd-123", "Aston Martin");
    	Carro c2 = new Carro("rrrr-111", "Ford");
    	Carro c3 = new Carro("aaaa-222", "Maserati");
    	c1.adicionar(c1);
    	c1.adicionar(c2);
    	c1.adicionar(c3);
    	try {
    		end = "\\carro.ser";
    		FileOutputStream fout = new FileOutputStream(end);
    		ObjectOutputStream oos = new ObjectOutputStream(fout);
    		oos.writeObject(c1);
    		oos.close();
    		System.out.println("Done");
            
    	}catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	    	
    	return end;
    }
    public static String usandoMotorista() {
    	String end = "";
    	Carro c3 = new Carro("aaaa-222", "Maserati");

    	Motorista m1 = new Motorista("Maria", "444", 20, c3, "000124");
    	m1.adicionar(m1);
    	
    	
    	try {
    		end = "\\motorista.ser";
    		FileOutputStream fout = new FileOutputStream(end);
    		ObjectOutputStream oos = new ObjectOutputStream(fout);
    		oos.writeObject(m1);
    		oos.close();
    		System.out.println("Done");
            
    	}catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	    	
    	return end;
    }
    
    
    public static String usandoCaneta() {
    	String end = "";
    	Caneta caneta = new Caneta("Roxa");
    	
    	
    	try {
    		end = "\\caneta.ser";
    		FileOutputStream fout = new FileOutputStream(end);
    		ObjectOutputStream oos = new ObjectOutputStream(fout);
    		oos.writeObject(caneta);
    		oos.close();
    		System.out.println("Done");
            
    	}catch(Exception ex){
 		   ex.printStackTrace();
 	   }
    	    	
    	return end;
    }
    
}