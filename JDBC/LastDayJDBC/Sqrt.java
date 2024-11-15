import java.sql.*;
import java.io.*;

class Sqrt {

    public static void main(String[] ss) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
           
            int t1 = 123;
            String t2 = "lalu";

            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result1 = s.executeQuery("SELECT * FROM Employee WHERE SQRT(empSalary) > 10");
           
            while (result1.next()) {
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
            }


        } catch (SQLException e) {
            System.out.println(e);
        }catch (Exception i) {System.out.println(i);}
    }
}

//C:\oracleexe\app\product\10.2.0\server\jdbc\lib\classes12.jar

/* 
This Java code selects records from the Employee table in an Oracle database where the square root of empSalary is greater than 10. It then prints the ID and name of each such record.

Import the required classes for Java SQL and Input/Output operations.
Create a class named Sqrt.
Inside the Sqrt class, create a main method that takes a string array as an argument.
Load the Oracle JDBC driver using the Class.forName method.
Establish a connection to the Oracle database using the DriverManager.getConnection method. Replace username and password with the actual username and password for the database.
Create a Statement object for executing SQL queries.
Execute an SQL query to select all records from the Employee table where the square root of empSalary is greater than
*/