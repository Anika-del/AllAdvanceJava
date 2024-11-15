import java.sql.*;
import java.util.*;

class TestUpdate1 {

        public static void main(String[] ss) {
        
        try {
            Driver d = new oracle.jdbc.driver.OracleDriver();

            Properties dbProp = new Properties();
            dbProp.put("user", "system");
            dbProp.put("password", "mca6");

            Connection c = d.connect("jdbc:oracle:thin:@localhost:1521:xe", dbProp);

            String z = "10002";
            String t2 = "hect";
           // String t3 = "2222";

            Statement s = c.createStatement();
            int z1 = s.executeUpdate("update emp101 set eno= '"+z+"' where ename= 'hect'" );
            System.out.println(z1);
            ResultSet result1 = s.executeQuery("select * from emp101");
           
            while (result1.next()){
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
        }
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        catch(Exception i){
            System.out.println(i);
    }
  }
}