import java.sql.*;


public class GenerateXmlFromDatabase {
    public static void main(String[] args) throws ClassNotFoundException{
        try {
			
			
           Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
    
            // Create a statement and execute the query
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_id, name, address, degination FROM employee");

            // Create an XML document
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<Company>\n");

            // Process the result set and generate XML tags
            while (resultSet.next()) {
                int empId = resultSet.getInt("employee_id");
                String Name = resultSet.getString("name");
                String Address = resultSet.getString("address");
                String Degination = resultSet.getString("degination");

                xmlBuilder.append("  <Employee id=\"" + empId + "\">\n");
                xmlBuilder.append("    <name>" + Name + "</name>\n");
                xmlBuilder.append("    <address>" + Address + "</address>\n");
                xmlBuilder.append("    <degination>" + Degination + "</degination>\n");
                xmlBuilder.append("  </Employee>\n");
            }
         xmlBuilder.append("</Company>");
            // Print the generated XML
            System.out.println(xmlBuilder.toString());
			
			




            // Close resources
            resultSet.close();
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
