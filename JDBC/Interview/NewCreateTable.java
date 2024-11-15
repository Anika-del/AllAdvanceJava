import java.sql.*;
public class NewCreateTable {
   
    public static void main(String[] args) {
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            // String t1 = "100";
            // String t2 = "Anika11";
            // String t3 = "10002";

            Statement s = c.createStatement();
            //s.executeUpdate("create table Animma(eno number, ename varchar(20), esal varchar(20))");
           // s.executeUpdate("insert into Animma values('"+t1+"','"+t2+"','"+t2+"')");
           s.executeUpdate("INSERT INTO Animma (eno, ename, esal) VALUES (99, 'Jane', 60000)");
          // s.executeUpdate("DELETE FROM Animma WHERE eno = 99");
            // s.executeUpdate("UPDATE Animma SET eno = 101, ename = 'John Doe', esal = 50000 WHERE eno = 100");
           
            System.out.println("data updated");
            ResultSet result1 = s.executeQuery("select * from Animma");
        
            while (result1.next()) {
               // System.out.println(result1.getString("ename") + " = " + result1.getString(2));
               System.out.println(result1.getString(1));
               System.out.println(result1.getString(2));
                System.out.println(result1.getString(3));
            }
    
        }catch(SQLException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
