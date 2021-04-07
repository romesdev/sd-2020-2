package sockets;

import java.io.Serializable;
import java.net.InetAddress;

//todas as classes presentes na transferência estão serializadas
public class RemoteObjectReference implements Serializable{



	private InetAddress ipEndereço;


	
	private int porta, objectId;
	private long time;


	private Class<?> mInterface;
	
	public RemoteObjectReference(InetAddress ip, int porta, int objectId, long time, Class<?> mInterface) {
		super();
		this.ipEndereço = ip;
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
		return ipEndereço;
	}



	@Override
	public String toString() {
		return "RemoteObjectReference [ipEndereço=" + ipEndereço + ", porta=" + porta + ", objectId=" + objectId
				+ ", time=" + time + ", mInterface=" + mInterface + "]";
	}
	
	
}