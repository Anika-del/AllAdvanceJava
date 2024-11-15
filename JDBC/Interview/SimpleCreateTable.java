import java.sql.*;

class SimpleCreateTable {

    public static void main(String[] ss) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            Statement s = c.createStatement();
            
           s.executeUpdate("create table Akta(eno number,ename varchar(12),esal number)"); //create table

           System.out.println("Table create secussefully ...");

        } catch (Exception i) {
            System.out.println(i);
        }
    }
}

