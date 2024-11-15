package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateTest
{
 public static void main(String[] args)
 {
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
   EntityManager manager = factory.createEntityManager();
   EntityTransaction t= manager.getTransaction();
   t.begin();
   Student std=manager.find(Student.class,new Long(2001));
   System.out.println(std.getId());
   System.out.println(std.getFirstname());
   std.setFirstname("bala");
   manager.persist(std);
   
   t.commit();
   manager.close();
   factory.close();
 }
}
   
   
   /*
   
E:\Advance_java\J2EE\JPA\StudentEntryCurd>javac -d . *.java

E:\Advance_java\J2EE\JPA\StudentEntryCurd>java mypack.RemoveTest
   */