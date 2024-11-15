package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SubString
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
Query query=em.createQuery("UPDATE Employee emp SET emp.empName=SUBSTRING(emp.empName,1,4)");
      int updatedRecord=query.executeUpdate();
	  
		
		
		 System.out.println(updatedRecord+"records are updated..");
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}

/*

*/	
	