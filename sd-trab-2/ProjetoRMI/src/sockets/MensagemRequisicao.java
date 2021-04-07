package sockets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

//todas as classes presentes na transferência estão serializadas

public class MensagemRequisicao implements Serializable{
	public static final int REPLY = 1;

	public static final int REQUEST = 0;
	
	private int type;
	private RemoteObjectReference remoteObjectRef;
	private long requestId;
	private byte args[];
	private int methodId;
	private static long next = 0;	


	
	
	public MensagemRequisicao(RemoteObjectReference remoteObjectRef, int methodId, Object[] args) throws IOException {
		super();
		
		this.remoteObjectRef = remoteObjectRef;
		this.methodId = methodId;
		this.args = toByteArray(args);
		
		this.type = REQUEST;
		this.requestId = next++;
	}

	public MensagemRequisicao(int methodId, byte[] args) {
		super();
		this.methodId = methodId;
		this.args = args;		
		this.type = REPLY;
	}
	
	
	
	public byte[] toBytes() {//pega o contexto (this) e transforma para bytes

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		byte[] array;
		try {
			out = new ObjectOutputStream(bytes);
			out.writeObject(this);
			out.flush();
			array =  bytes.toByteArray();
			bytes.close();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());;
			e.printStackTrace();
			return null;
		}
		
		
		
		return array;
	}
	
	
	//retorna um array de bytes usando as funções do ByteArrayOutputStream
	private byte[] toByteArray(Object[] obj) throws IOException {
		ObjectOutputStream out = null;
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		byte[] outBytes = null;
		try {
		  out = new ObjectOutputStream(bytes);   
		  out.writeObject(obj);
		  out.flush();
		  outBytes = bytes.toByteArray();//Creates a newly allocated byte array.
		  
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		  try {
		    bytes.close();
		  } catch (IOException ex) {
			  System.out.println(ex.getMessage());
		  }
		}
		
		return outBytes;
	}
	
	
	
	
	
	
	//pega os bytes e convertem para um objeto com a chamda da funcao bytesToObject
	public static MensagemRequisicao deBytes(byte[] bytes) {
		return (MensagemRequisicao) bytesToObject(bytes);
	}
	
	private static Object bytesToObject(byte[] bytes) {
		ByteArrayInputStream bytesInput = new ByteArrayInputStream(bytes);
		ObjectInput input = null;
		Object obj;
		try {
			input = new ObjectInputStream(bytesInput);
			obj = input.readObject();
		} catch (Exception e) {
			System.err.println(e.getMessage());;
			e.printStackTrace();
			return null;
		}
		
		try {
			if(input != null)
				input.close();
			return obj;
		} catch (Exception e) {
			System.err.println(e.getMessage());;
			e.printStackTrace();
			return null;
		}
	}
	
	

	public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	
	public byte[] getArgs() {
		return args;
	}
	
	public Object[] getObjectsArgs() {
		return (Object[]) bytesToObject(args);
	}

	public void setArgs(byte[] args) {
		this.args = args;
	}
	
	public void setArgs(String[] args) throws IOException {
		this.args = toByteArray(args);
	}
	
	

	


	@Override
	public String toString() {
		return "MensagemRequisicao [type=" + type + ", remoteObjectRef=" + remoteObjectRef + ", requestId=" + requestId
				+ ", args=" + Arrays.toString(args).toString() + ", methodId=" + methodId + "]";
	}

	public RemoteObjectReference getRemoteObjectRef() {
		return remoteObjectRef;
	}


	public void setRemoteObjectRef(RemoteObjectReference remoteObjectRef) {
		this.remoteObjectRef = remoteObjectRef;
	}



	
}
