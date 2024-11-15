
import javax.persistence.PersistenceContext;
import java.io.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory; 
import javax.persistence.PersistenceUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import mypack.Customer;

public class MyServlet extends HttpServlet
{
public MyServlet()
{
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	
PrintWriter pw = response.getWriter();
EntityManagerFactory factory = Persistence.createEntityManagerFactory("appsquadzjpa"); 
EntityManager manager = factory.createEntityManager();

EntityTransaction t = manager.getTransaction();
t.begin();
Customer cust = new Customer();
cust.setId(9001);
cust.setFirstName("amit1001"); 
cust.setLastName("bhatia10001");
manager.persist(cust);

t.commit();
manager.close();
pw.println("record added successfully");
//factory.close();
}
}