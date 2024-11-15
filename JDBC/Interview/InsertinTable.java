import java.sql.*;

class InsertinTable {


    public static void main(String[] ss) {

    try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            //  String t1 = "101";
            //  String t2 = "Anika1";
            //  String t3 = "10000";

             String t1 = "102";
             String t2 = "Anika2";
             String t3 = "10001";
            
            //  String t1 = "103";
            //  String t2 = "Anika3";
            //  String t3 = "10002";

            Statement s = c.createStatement();
            int x = s.executeUpdate("insert into Anika values('"+t1+"','"+t2+"','"+t3+"')");
            System.out.println(x);
            ResultSet result1 = s.executeQuery("select * from Anika");

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