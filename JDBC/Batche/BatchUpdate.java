import java.sql.*;

class BatchUpdate {
    public static void main(String[] ss) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
    
            Statement s = c.createStatement();
            String s1 = "update emp102 set name = 'lalu2' where pass = 'Gadar2'";
            String s2 = "insert into emp102 values('Niramni', '14mar')";
            String s3 = "delete from emp102 where pass = '16jan'";
            //String s1 = "update emp101 set ename = 'lalu2' where eno = 10007";
            //String s2 = "insert into emp101 values(1005, 'Anika', '14')";
           // String s3 = "delete from emp101 where eno = 10003";
            s.addBatch(s1);
            s.addBatch(s2);
            s.addBatch(s3);
            s.executeBatch();

            ResultSet result1 = s.executeQuery("select * from emp101");
            while(result1.next()){
                System.out.println("name"+ result1.getString(1));
                System.out.println("pass"+ result1.getString(2));
            }
        }catch(Exception e) {System.out.println(e);}


            }
        }


    /*
D:\JDBC\Batche>java BatchUpdate
name10004
passhector
name10004
passhector
name10003
passcutipie
name10003
passcutipie
name10007
passlovi
*/