package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import java.math.*;

public class NamedQuery1
{
  public static void main(String ram[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createNativeQuery("SELECT empSalary FROM Employeenative order by empSalary desc");
	  
		List list=query.getResultList();
		Iterator<BigDecimal> itr=list.iterator();
		while(itr.hasNext())
		{
		 BigDecimal str=itr.next();
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

/*
Emp Name:1004
Emp Name:1003
Emp Name:1002
Emp Name:1001
*/	
	