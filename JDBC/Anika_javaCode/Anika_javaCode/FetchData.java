//fetch data from database using JDBC oracle and print the data in JFrame.

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FetchData extends JFrame {
    public FetchData() {
        super("Data Display");
        setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");

            // Process the result set
            while (resultSet.next()) {
                textArea.append(resultSet.getString(1) + " - " + resultSet.getString(2) + "\n");
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FetchData();
    }
}
