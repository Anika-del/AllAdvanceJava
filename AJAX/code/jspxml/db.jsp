<%@ page import="java.io.*,java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
response.setContentType(text/xml");
String sn=request.getParameter("ok");
int i=Integer.parseInt(sn);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle/thin:@localhost:1521:XE", "system", "mca6");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from students where id=" +i);

if(rs.next())

out.println("<students>");
out.println("<stdid>"+rs.getInt(1)+"</stdid>");
out.println("<stdfirstname>"+rs.getString(2)+"</stdfirstname>");

out.println("<stdage>"+rs.getString(3)+"</stdage>");

ResultSet rs = st.executeQuery("select from students where id=" +1 );
out.println("</students>");
 }