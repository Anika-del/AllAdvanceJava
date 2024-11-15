package mypack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentTest
{
 public static void main(String [] arg)
 {
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("appsquadzjpa");
    EntityManager manager=factory.createEntityManager();
	EntityTransaction t=manager.getTransaction();
	t.begin();
	Student std1=new Student(2001,"salman420","khan","salman420@gmail.com");
	Student std2=new Student(2002,"amiir420","khan","amir420@gmail.com");
	Student std3=new Student(2003,"rohit420","khan","salman420@gmail.com");
	Student std4=new Student(2004,"amar420","khan","amiir420@gmail.com");
	System.out.println("persistence entites...");
	manager.persist(std1);
	manager.persist(std2);
	manager.persist(std3);
	manager.persist(std4);
	t.commit();
	manager.close();
	factory.close();
	System.out.println("Successfully persisted..");
 }
}