import my.*;
import java.rmi.*;
import java.rmi.server.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DemoServlet extends GenericServlet
{
public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException
	{

res.setContentType("text/html");
PrintWriter out = res.getWriter();
int firstno = Integer.parseInt(req.getParameter("firstno"));
int secondno = Integer.parseInt(req.getParameter("secondno"));
out.println("<html><body>");

	try{
		my.MyRemote m = (my.MyRemote)Naming.lookup("rmi://localhost:1099/codesquadz");
		out.println(m.add(firstno,secondno));
	}catch(Exception e){
		System.out.println(e);
		}
		
		out.println("</body></html>");
	}
}

