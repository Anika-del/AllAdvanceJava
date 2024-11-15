import java.sql.*;

class TestInsert {


    public static void main(String[] ss) {

    try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
             //String t1 = "10004";
             //String t2 = "hector";
             //String t3 = "1234";

            // String t1 = "10005";
            // String t2 = "cute";
            // String t3 = "2345";
            
             String t1 = "10007";
             String t2 = "punita";
             String t3 = "1432";

            //String t1 = "10008";
           // String t2 = "loviii";
           // String t3 = "1543";

            Statement s = c.createStatement();
            int x = s.executeUpdate("insert into emp101 values('"+t1+"','"+t2+"','"+t3+"')");
            System.out.println(x);
            ResultSet result1 = s.executeQuery("select * from emp101");

            while (result1.next())
            {
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
               System.out.println(result1.getString(3));
            } 
    }catch (SQLException e) 
    {
            System.out.println(e.getMessage());
    }catch(Exception i){
        System.out.println(i);
    }
    }
}

//int x=executeUpdate"insert into emp values('"+t1+"',"+t3+")";  