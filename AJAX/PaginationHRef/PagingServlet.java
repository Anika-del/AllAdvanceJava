import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
 import javax.sql.*;
 
public class PagingServlet extends HttpServlet
{
	
PrintWriter out;
int p;
Integer page_no;
static String table; 

public void service(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
{
	
res.setContentType("text/html");
out=res.getWriter();

try
{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
	   
       Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	   String ta = req.getParameter("table");
       System.out.println("1");
      if(ta!=null)
        table=ta;
      else
        table = table;
	
System.out.println(table); 
ResultSet rs = s.executeQuery("select * from " +table);
ResultSetMetaData rmdt = rs.getMetaData();
int columnCount = rmdt.getColumnCount();
System.out.println(columnCount);

rs.last();
int total_rec = rs.getRow();
System.out.println(total_rec);
int rec_per_page=5;
System.out.println(rec_per_page); 
int pages = total_rec/rec_per_page;
int r=total_rec%rec_per_page;
if(r==0)
pages=pages;
else
pages=pages+1;

res.addIntHeader("pages" pages);
for(int I=1; I<=pages; I++)
{
out.println("<a href='#' onclick='hclick("+1+")'>"+1+"</a>");
}
String url = req.getParameter("pageno");
System.out.println(url +"URL");
if(url==null)
page_no=new Integer(1);
else
page_no=new Integer(Integer.parseInt(req.getParameter("pageno")));
p=page_no.intValue();
int first, last;
last=p*5;
first=last+1-5;
out.println("<html><body>");
out.println("<table bgcolor='green' border=1 width=400>");
out.println("<tr>");
for(int i=1; i<=columnCount; i++)
{ 
   out.println("<th>" +rmdt.getColumnName(i)+"</th>");
}
for(int I=first; I<=last; I++)
{
rs.absolute(first);
out.println("<tr>");
for(int m=1; m<=columnCount; m++)
{
	out.println("<td>"+rs.getString(m)+"</td>");
}
first++;
}
out.println("</body></html>");
}catch(Exception e){}
}
}