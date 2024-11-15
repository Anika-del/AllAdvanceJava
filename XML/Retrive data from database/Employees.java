import java.sql.*;

public class Employees {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Replace with your actual connection details
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "mca6";

            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, department FROM employees");

            // Process the result set
            while (resultSet.next()) {
                String employeeId = resultSet.getString("id");
                String employeeName = resultSet.getString("name");
                String hireDate = resultSet.getString("department");

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Hire Date: " + hireDate);
                System.out.println();
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
