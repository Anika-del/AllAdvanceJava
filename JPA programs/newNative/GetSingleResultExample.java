package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetSingleResultExample
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createQuery("SELECT emp FROM Employee emp WHERE emp.id=:id");
		      query.setParameter("id",2023);
		 Employee emp=(Employee)query.getSingleResult();
		 System.out.print("Emp Name:"+emp.getEmpName());
		 System.out.print("Salary:"+emp.getEmpSalary());
		 System.out.println();
		 
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}
	