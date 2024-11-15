//write a scroll bar using jdbc to fetch data from oracle jdbc

import java.sql.*;
import java.io.*;

class ScrollBarJDBC {
    public static void main(String[] ss) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet result1 = s.executeQuery("SELECT * FROM Employee");
            ResultSetMetaData rsmd = result1.getMetaData();
            int count = rsmd.getColumnCount();
            System.out.println(count);
            for(int i=1; i<=count; i++){
                System.out.println(rsmd.getColumnName(i));
                System.out.println(rsmd.getColumnTypeName(i));
            }

            while (result1.next()) {
                System.out.println(result1.getString(1));
                System.out.println(result1.getString(2));
            }

            result1.absolute(10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);
            
            result1.previous();
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);

            result1.first();
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);

            result1.last();
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);

            result1.afterLast();
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);

            result1.beforeFirst();
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.relative(-10);
            System.out.println(result1.getString(1));
            System.out.println(result1.getString(2));
            result1.absolute(10);


            result1.close();

            s.close();
            c.close();

        }catch (SQLException e) {
            System.out.println(e);
        }
        catch (Exception i) {
            System.out.println(i);
        }


    }
}
 
