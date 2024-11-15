import java.sql.*;
public class CreateTable {

        public static void main(String[] ss) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
                Statement s = conn.createStatement();
                
                s.executeUpdate("create table Anika(erollno number,ename varchar(12),esal number)"); //create table
    
                System.out.println("Table create secussefully ...");
    
                ResultSet result1 = s.executeQuery("select * from Anika");
               
                while (result1.next()) 
                {
                    System.out.println("selection" +result1.getString("ename") + " = " + result1.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e);
            } catch (Exception i) {
                System.out.println(i);
            }
        }
    }
    
    // C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\odbc14.jar
    
    //  Add code to retrive data from another table
    //c:/jar fx ojdbc14.jar
    
