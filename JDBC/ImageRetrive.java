import java.sql.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DisplayImage {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish a connection
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "", "password");

            // Prepare the SQL statement
            String sql = "SELECT image FROM my_table WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 1); // Assuming you're retrieving the image with ID 1

            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get the image as a Blob
                Blob blob = rs.getBlob("image");
                // Convert the Blob to a byte array
                byte[] imgData = blob.getBytes(1, (int) blob.length());
                // Convert the byte array to a BufferedImage
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgData));

                // Display the image in a JFrame
                ImageIcon icon = new ImageIcon(img);
                JLabel label = new JLabel(icon);
                JFrame frame = new JFrame();
                frame.getContentPane().add(label, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
