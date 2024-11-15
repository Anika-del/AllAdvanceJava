import java.sql.*;
import java.io.*;

class SavePoint {
   // some commit some rollback we make using savepoint
   //2 pr commit chalaya and 2 pr rollback 
   //hm jattu ko delete nhi hone denge and pappu ko insert nhi hone denge
   //ms dhoni insert ho jayega

    public static void main(String[] ss) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            Statement s = c.createStatement();
            c.setAutoCommit(false);
            int x = s.executeUpdate("update emp101 set name='meesa' where pass='190ct'");
            s.executeUpdate("insert into emp101 values('dhonicsk2037','dhonicsk2037')");
            Savepoint savept = c.setSavepoint("aaa");
            int x1 = s.executeUpdate("delete from emp101 where pass='jaddu'");
            s.executeUpdate("insert into emp101 values('pappu','rahul)");
            c.rollback(savept);

            //c.releaseSavepoint(savept);
            c.commit();

            ResultSet result1 = s.executeQuery("select * from emp101");
            while(result1.next()){
                System.out.println("id : "+ result1.getString(1));
                System.out.println("name : "+ result1.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}