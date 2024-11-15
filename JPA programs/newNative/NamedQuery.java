package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedQuery
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createNativeQuery("SELECT empName FROM Employeenative order by empName desc");
	  
		List list=query.getResultList();
		Iterator<String> itr=list.iterator();
		while(itr.hasNext())
		{
		 String str=itr.next();
		 System.out.print("Emp Name:"+str);
		 System.out.println();
	   }
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}
	