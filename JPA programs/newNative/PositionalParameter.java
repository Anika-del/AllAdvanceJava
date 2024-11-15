package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class PositionalParameter
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
Query query=em.createQuery("SELECT emp FROM Employee emp WHERE emp.empSalary=?1 OR emp.empName=?2");
		 query.setParameter(1,1001);
		 query.setParameter(2,"LALU1K1");
	  
		List list=query.getResultList();
		Iterator<Employee> itr=list.iterator();
		while(itr.hasNext())
		{
		 Employee emp=itr.next();
		 System.out.print("Emp Name:"+emp.getEmpName());
		 System.out.print("Emp Salary:"+emp.getEmpSalary());
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

/*

*/	
	