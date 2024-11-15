<%@ page import="java.io.*,java.sql.*"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%

response.setContentType("text/xml");
String sn = request.getParameter("ok");
int i=Integer.parseInt(sn);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhst:1521:XE","system","mca6");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select name from students where age =" + i);
 out.println("<students>");

while(rs.next())
{
out.println("<stdname>"+rs.getString(1)+"</stdname>" );
}
out.println("</students>");

rs.close();
st.close(); 
con.close();

%>