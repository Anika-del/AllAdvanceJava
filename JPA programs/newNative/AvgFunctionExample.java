package mypack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AvgFunctionExample
{
  public static void main(String ar[])
  {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("appsquadzjpa");
	 EntityManager em=emf.createEntityManager();
	 try
	 {
		 EntityTransaction entr=em.getTransaction();
		 entr.begin();
		 Query query=em.createQuery("SELECT emp FROM Employee emp WHERE emp.empSalary >(SELECT AVG(emp1.empSalary) FROM Employee emp1)");
		 
		 List list=query.getResultList();
		 Iterator iterator=list.iterator();
		 while(iterator.hasNext())
		 {
			 Employee emp=(Employee)iterator.next();
			    System.out.println("EmpName:"+emp.getEmpName());
			    System.out.println("EmpSalary:"+emp.getEmpSalary());
		 }
		 entr.commit();
	 }
finally{
	em.close();
  }	 
 }
}

/*
es type se compile and run karna hai than out aise ayega

E:\Advance_java\J2EE\JPA\NewNative>javac -d . *.java

E:\Advance_java\J2EE\JPA\NewNative>java mypack.AvgFunctionExample
This version of OpenJPA cannot read a persistence.xml document with a version different from "1.0". Found: version "2.0" in "file:/E:/Advance_java/J2EE/JPA/NewNative/META-INF/persistence.xml".
This version of OpenJPA cannot read a persistence.xml document with a version different from "1.0". Found: version "2.0" in "file:/E:/Advance_java/J2EE/JPA/NewNative/META-INF/persistence.xml".
May 20, 2024 8:01:46 AM org.hibernate.validator.util.Version <clinit>
INFO: Hibernate Validator 4.1.0
May 20, 2024 8:01:46 AM org.hibernate.validator.engine.resolver.DefaultTraversableResolver detectJPA
INFO: Instantiated an instance of org.hibernate.validator.engine.resolver.JPATraversableResolver.
[EL Info]: 2024-05-20 08:01:46.477--ServerSession(23664622)--EclipseLink, version: Eclipse Persistence Services - 2.3.2.v20111125-r10461
[EL Info]: 2024-05-20 08:01:47.312--ServerSession(23664622)--file:/E:/Advance_java/J2EE/JPA/NewNative/_appsquadzjpa login successful
EmpName:aamie421
EmpSalary:1004
EmpName:salaman420
EmpSalary:1003

*/