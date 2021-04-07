package sockets;

import java.io.Serializable;
import java.net.InetAddress;

//todas as classes presentes na transfer�ncia est�o serializadas
public class RemoteObjectReference implements Serializable{



	private InetAddress ipEndere�o;


	
	private int porta, objectId;
	private long time;


	private Class<?> mInterface;
	
	public RemoteObjectReference(InetAddress ip, int porta, int objectId, long time, Class<?> mInterface) {
		super();
		this.ipEndere�o = ip;
		this.porta = porta;
		this.objectId = objectId;
		this.time = time;
		this.mInterface = mInterface;
	}

	

	public Class<?> getmInterface() {
		return mInterface;
	}

	public void setmInterface(Class<?> mInterface) {
		this.mInterface = mInterface;
	}
	

	public int getPorta() {
		return porta;
	}

	public InetAddress getIp() {
		return ipEndere�o;
	}



	@Override
	public String toString() {
		return "RemoteObjectReference [ipEndere�o=" + ipEndere�o + ", porta=" + porta + ", objectId=" + objectId
				+ ", time=" + time + ", mInterface=" + mInterface + "]";
	}
	
	
}