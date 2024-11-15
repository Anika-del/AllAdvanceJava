import my.*;
import java.rmi.*;
import java.rmi.server.*;

public class Client
{
	public static void main(String s[])
	{
		try{
			my.MyRemote m = (my.MyRemote)Naming.lookup("rmi://localhost:1099/codesquadz");
			System.out.println(m.add(12,12));
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}