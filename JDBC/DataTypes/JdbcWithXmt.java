import java.sql.*;
import java.io.*;
import java.util.*;

public class JdbcWithXml
{
   public static void main(String[] args)
   {
      Connection conn = null;
      PreparedStatement pstmt = null;
      Statement stmt = null;
      
      ResultSet rs = null;
      try{

         Class.forName("oracle.jdbc.driver.OracleDriver");

         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
         
         stmt = conn.createStatement();
         createXMLTable(stmt);

         //Open a FileStream;
         File f = new File("XML_Data.xml");
         long fileLength = f.length();
         FileInputStream fis = new FileInputStream(f);

         String SQL = "INSERT INTO XML_Data VALUES(?,?)";
         pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1,200);
         pstmt.setAsciiStream(2,fis,(int) fileLength);
         pstmt.execute();

         fis.close();

         SQL = "SELECT Data FROM XML_Data WHERE id = 200";
         rs = stmt.executeQuery(SQL);

         if(rs.next()){

            InputStream xmlInputStream = rs.getAsciiStream(1);
            int c;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while((c = xmlInputStream.read())!= -1)
            bos.write(c);
            PrintStream pw = new PrintStream(new FileOutputStream("abc.xml"));
            System.out.println(bos.toString());
         }
         rs.close();
         stmt.close();
         conn.close();
         pstmt.close();

      }catch(Exception se){System.out.println(se);}
      //...
   }
}