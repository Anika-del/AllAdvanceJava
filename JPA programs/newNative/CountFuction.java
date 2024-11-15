package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountFuction
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createQuery("SELECT COUNT(emp.empName) FROM Employee emp");
		 Number cResults=(Number)query.getSingleResult();
		 System.out.println("Total count result="+cResults);
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}
	