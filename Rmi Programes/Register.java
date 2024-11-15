package my;
import java.rmi.*;
import java.rmi.server.*;
public class Register 
{
	public static void main(String args[])
	{
		try{
		my.MyServer m=new my.MyServer();
		Naming.rebind("codesquadz",m);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}