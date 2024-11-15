import java.sql.*;
import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CompanyEmp {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            // Create a statement and execute the query
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_id, name, address, degination FROM employee");

            // Create an XML document
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();

            Element rootElement = doc.createElement("Company");
            doc.appendChild(rootElement);

            // Process the result set and generate XML tags
            while (resultSet.next()) {
                int empId = resultSet.getInt("employee_id");
                String Name = resultSet.getString("name");
                String Address = resultSet.getString("address");
                String Degination = resultSet.getString("degination");

                Element employee = doc.createElement("Employee");
                rootElement.appendChild(employee);

                employee.setAttribute("id", String.valueOf(empId));

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(Name));
                employee.appendChild(nameElement);

                Element addressElement = doc.createElement("address");
                addressElement.appendChild(doc.createTextNode(Address));
                employee.appendChild(addressElement);

                Element deginationElement = doc.createElement("degination");
                deginationElement.appendChild(doc.createTextNode(Degination));
                employee.appendChild(deginationElement);
            }

            // Create and write the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("Company.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);

            System.out.println("XML File Created and Saved To Specified path!");

            // Close resources
            resultSet.close();
            statement.close();
            c.close();
        } catch (SQLException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
