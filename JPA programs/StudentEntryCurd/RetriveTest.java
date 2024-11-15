package mypack;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RetriveTest
{
 public static void main(String[] args){
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa");
   EntityManager manager = factory.createEntityManager();
   
   EntityTransaction t= manager.getTransaction();
   t.begin();
   
   System.out.println("fetching record having");
   Student std = manager.find(Student.class,new Long(2001));
   //Student student = manager.getRefrence(Student.class,new Long(1002));
  /* the getRefrence method works like the find method except that if the entity on=bject is not already
   managed by  the EntityManager a hollow object might be returned (null is never returned). A hollow object is
   initialized with the valid primary key but all its other persistent fields are uninitialized*/
   System.out.println(std.getId());
   System.out.println(std.getFirstname());
   t.commit();
   manager.close();
   factory.close();
 }
}