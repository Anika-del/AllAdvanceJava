package my;
import java.rmi.*;

public interface MyRemote extends Remote
{
public int add(int firstno,int secondno)throws RemoteException;

}