package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LowerFunctionExample
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createQuery("SELECT emp FROM Employee emp");
		      
		List list=query.getResultList();
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
		 Employee emp=(Employee)iterator.next();
		 System.out.print("Emp Name:"+emp.getEmpName());
		 System.out.println();
	     }
//	Query lQuery=em.createQuery("UPDATE Employee emp SET emp.empName=LOWER(emp.empName)");		  
	Query lQuery=em.createQuery("UPDATE Employee emp SET emp.empName=UPPER(emp.empName)");	
     int updateData=lQuery.executeUpdate();
    System.out.println(updateData+"record(s) are Updated");	  
		 entr.commit();
		 }
		 finally
		 {
		   em.close();
		 }
	} 
}
	