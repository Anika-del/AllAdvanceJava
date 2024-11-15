package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SqrtFunctionExample
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
Query query=em.createQuery("SELECT emp FROM Employee emp WHERE SQRT(emp.empSalary)>5");
	  
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
	