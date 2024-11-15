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
            String t1 = "100";
            String t2 = "hect";
            String t3 = "100000";

            Statement s = c.createStatement();

            // int z1 = s.executeUpdate("update emp101 set eno = '10003', ename= 'cutipie' where ename= 'cute'" );
            int z1 = s.executeUpdate("update Anika set erollno= '+t1+', ename='t2', esal='t3' where ename= 'Anika1'" );
            System.out.println(z1);
            ResultSet result1 = s.executeQuery("select * from Anika");
           
            while (result1.next()){
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
                System.out.println(result1.getString(3));
        }
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        catch(Exception i){
            System.out.println(i);
    }
  }
}