import java.sql.*;
import java.io.*;

public class ImageJDBC {
	
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            // Prepare the statement to insert image data
            PreparedStatement ps = con.prepareStatement("INSERT INTO IMGTABLE VALUES (?, ?)");
           // ps.setString(1, "sonoo"); // Image name
		    ps.setString(1, "ddd");
            //FileInputStream fin = new FileInputStream("d:\\g.jpg"); // Path to the image file
			FileInputStream fin = new FileInputStream("d.jpeg");
            ps.setBinaryStream(2, fin, fin.available()); // Set the image data

            int i = ps.executeUpdate();
            System.out.println(i + " records affected");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
