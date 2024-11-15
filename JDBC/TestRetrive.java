import java.sql.*;

class TestRetrive {

    public static void main(String[] ss) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            Statement s = c.createStatement();
            
           s.executeUpdate("create table emp101(eno number,ename varchar(12),esal number)"); //create table

           System.out.println("Table create secussefully ...");

           /*  ResultSet result1 = s.executeQuery("select * from emp101");
           
            while (result1.next()) 
            {
                System.out.println(result1.getString("name") + " = " + result1.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);*/
        } catch (Exception i) {
            System.out.println(i);
        }
    }
}

// C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\odbc14.jar

//  Add code to retrive data from another table
//c:/jar fx ojdbc14.jar
