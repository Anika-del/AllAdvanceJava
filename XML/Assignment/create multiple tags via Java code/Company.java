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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Company {
    public static void main(String args[]) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            // Define root element
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("Company");
            document.appendChild(rootElement);

            // Employee data (you can replace this with your actual data)
            String[][] EmployeeData = {
                {"Aaliya", "1001", "GKP", "abc@gmail.com", "IT", "6081362908"},
				{"Sonam", "1002", "Noida", "a@gmail.com", "IT", "7081362908"},
				{"Pooja", "1003", "Lucknow", "ab@gmail.com", "HR", "8081362908"},
				{"Sangeeta", "1004", "Kanpur", "efg@gmail.com", "IT", "9081362908"},
				{"Roli", "1005", "Allahabad", "dze@gmail.com", "Testing", "5081362908"}
                // Add more Employee records here
				
            };

            // Create separate <Employee> tags for each record
            for (int i = 0; i < EmployeeData.length; i++) {
                Element employee = document.createElement("Employee");
                rootElement.appendChild(employee);

            /*    Attr attribute = document.createAttribute("id");
                attribute.setValue(String.valueOf(i + 1));
                employee.setAttributeNode(attribute);*/

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(EmployeeData[i][0]));
                employee.appendChild(name);
				
				Element id = document.createElement("id");
                id.appendChild(document.createTextNode(EmployeeData[i][1]));
                employee.appendChild(id);

                Element address = document.createElement("address");
                address.appendChild(document.createTextNode(EmployeeData[i][2]));
                employee.appendChild(address);

                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(EmployeeData[i][3]));
                employee.appendChild(email);
				
				Element degination = document.createElement("degination");
                degination.appendChild(document.createTextNode(EmployeeData[i][4]));
                employee.appendChild(degination);

                Element phone = document.createElement("phone");
                phone.appendChild(document.createTextNode(EmployeeData[i][5]));
                employee.appendChild(phone);
				
				
            }

            // Create and write the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("createCompany.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);

            System.out.println("File create and Saved To Specified path!");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
