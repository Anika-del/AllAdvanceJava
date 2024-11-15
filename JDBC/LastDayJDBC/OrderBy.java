import java.sql.*;
import java.io.*;

class OrderBy {
    

    public static void main(String[] ss) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
             int t1 = 123;
             String t2 = "lalu";

            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result1 = s.executeQuery("SELECT * FROM Employee ORDER BY empSalary DESC");

            while (result1.next()) {
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }catch(Exception i) {
            System.out.println(i);
        }
    }
}