package mypack;

import javax.persistence.EntityManager;
import Javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence; 
import javax.persistence.Query;

public class EmployeeTest
{
	
 public static void main(String[] args)
 {
	 
EntityManagerFactory factory = Persistence.createEntityManagerFactory("uppequaozjpa");

EntityManager manger = factory.createEntityManager();
Entry Transaction t = manger.getTransection(); 
t.begin();
 Employee std1=new Employee(2012, "salman421" ,1001); 
 Employee std2=new Employee(420, "aamir422" ,1002);
 Employee std3=new Employee(2023, "salman23",1003),
 Employee std4=new Employee(421, "aamir426", 1004);
System.out.println("persisting entities....");

 manger.persist(std1); 
 manger.persist(std2);
 manger.persist(std3);
 manger.persist(std4);
 
t.commit();
manger.close(); 
factory.close();
System.out.println("Successfully persisted.");
 }
}
