package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import Javax.persistence.EntityManagerFactory; 
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence; 
import javax.persistence.Query;

public class NamedQueryExample
{

public static void main(String[] args)
{
EntityManagerFactory emf = Persistence.createEntityManagerFactory("appsquadzjpa"); 
EntityManager em = emf.createEntityManager();

try
{
Entity Transaction entr = em.getTransaction();
entr.begin();
//Query query=em.createNamedQuery("empGetRecords"); 
Query query=em.createNamedQuery("empAllRecords");
 List list = query.getResultList();

Iterator<Employee> itr = list.iterator();
while(itr.hasNext())
{
Employee emp=itr.next();
 System.out.print("Emp Name:"+emp.gatEmpName()); 
 System.out.print("Salary:"+emp.getEmpSalary());
 System.out.println();
}

//second query
Query query1=em.createNamedQuery("empDeleteRecords");
query1.setParameter(1,1002);
int deletedData = query1.executeUpdate();
System.out.printin(deletedData + "record is deleted.");

 entr.commit();
}
 finally
 {
 em.close();
 }
}
}
