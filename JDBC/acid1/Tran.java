import java.sql.*;
import java.io.*;

//set commit in database save check database
//then when you connit then it will be save
class Tran {
    public static void main(String[] ss) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "m");
            Statement s = c.createStatement();
            c.setAutoCommit(false);
            int x = s.executeUpdate("update emp102 set name='rabari11' where pass='14mar'");
            ResultSet result1 = s.executeQuery("select * from emp102 where pass='8july'");
            while (result1.next()) {
                System.out.println("name " + result1.getString(1));
                System.out.println("pass " + result1.getString(2));
            }

            c.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}