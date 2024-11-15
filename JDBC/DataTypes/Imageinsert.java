import java.sql.*;
import java.io.*;


public class Imageinsert {

    public static void main(String[] args) throws Exception {
        //class.forName("com.mysql.jdbc.Driver");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
        // Connection conn = DriverManager.getConnection("jdbc:mysql://@localhost:3306/appsquadz56", "root", "root");
        Statement st = conn.createStatement();
        st.executeUpdate("drop table image18");
        st.executeUpdate("create table image18(name varchar(15),image blob)");
        File file = new File("Ani.jpg");
        FileInputStream fis = new FileInputStream(file);
       
        PreparedStatement ps = conn.prepareStatement("insert into image18(name,image) values(?,?)");
        ps.setString(1, "Ani");
        ps.setBinaryStream(2,fis,(int) file.length());
        ps.execute();
        ps.close();
        ps.close();
    }
}