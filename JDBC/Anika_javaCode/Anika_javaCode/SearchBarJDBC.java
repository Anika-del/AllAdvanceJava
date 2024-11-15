//write a program which is search data from database using JDBC oracle and print the data.

import java.sql.*;

public class SearchBarJDBC {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "system";
        String password = "mca6";
        String sql = "select * from emp55 where name =?";
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, 2);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
             //   System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
             System.out.println(rs.getString(1) + " " + rs.getString(2) );
            }
            rs.close();
            st.close();
            con.close();
            System.out.println("Done");
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    }
        
