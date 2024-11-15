package my;
import java.rmi.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MyRemote extends Remote
{
public int add(int x,int y)throws RemoteException;
}