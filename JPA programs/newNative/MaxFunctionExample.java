package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MaxFunctionExample
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		// Query query=em.createQuery("SELECT MAX(emp.empSalary) FROM Employee emp");
		 Query query=em.createQuery("SELECT MIN(emp.empSalary) FROM Employee emp");
		      
		
		 Number cResults=(Number)query.getSingleResult();
		 System.out.print("Total count result"+cResults);
		
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}
	