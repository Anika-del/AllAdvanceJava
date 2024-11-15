package mypack;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AvgFunction
{
  public static void main(String ar[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createQuery("SELECT AVG(emp.empSalary) FROM Employee emp");
		 Number cResults=(Number)query.getSingleResult();
		 System.out.println("total count result="+cResults);
		 entr.commit();
	 }
	 finally{
		 em.close();
	 }
  }
}

/*

total count result=1002.5
*/
