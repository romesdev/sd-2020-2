package caseRemoto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {
    String metodoRemoto1(String end) throws RemoteException;
    String metodoRemoto2(String end) throws RemoteException;
    String metodoRemoto3(String end) throws RemoteException;
    String metodoRemoto4(String end) throws RemoteException;


}