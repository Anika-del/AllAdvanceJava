import java.sql.*;
import java.util.*;

class TestUpdate {

        public static void main(String[] ss) {
        
        try {
            Driver d = new oracle.jdbc.driver.OracleDriver();

            Properties dbProp = new Properties();
            dbProp.put("user", "system");
            dbProp.put("password", "mca6");

            Connection c = d.connect("jdbc:oracle:thin:@localhost:1521:xe", dbProp);
            String z = "10002";
            String x = "hect";
            String y = "4321";

            Statement s = c.createStatement();

            // int z1 = s.executeUpdate("update emp101 set eno = '10003', ename= 'cutipie' where ename= 'cute'" );
            int z1 = s.executeUpdate("update emp101 set eno= '+z+', esal='x', ename='y' where eno= '10004'" );
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