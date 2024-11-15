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

public class StudentMultiXmlTags {
    public static void main(String args[]) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            // Define root element
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("school");
            document.appendChild(rootElement);

            // Simulated student data (you can replace this with your actual data)
            String[][] studentData = {
                {"ankush", "thakur1", "abc@gmail.com", "6081362908"},
				{"ankushi", "thakur2", "a@gmail.com", "7081362908"},
				{"ankusha", "thakur3", "ab@gmail.com", "8081362908"},
				{"ankusho", "thakur4", "abcd@gmail.com", "9081362908"},
				{"ankushv", "thakur5", "abcde@gmail.com", "5081362908"}
                // Add more student records here
            };

            // Create separate <Student> tags for each record
            for (int i = 0; i < studentData.length; i++) {
                Element student = document.createElement("Student");
                rootElement.appendChild(student);

                Attr attribute = document.createAttribute("id");
                attribute.setValue(String.valueOf(i + 1));
                student.setAttributeNode(attribute);

                Element firstname = document.createElement("firstname");
                firstname.appendChild(document.createTextNode(studentData[i][0]));
                student.appendChild(firstname);

                Element lastname = document.createElement("lastname");
                lastname.appendChild(document.createTextNode(studentData[i][1]));
                student.appendChild(lastname);

                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(studentData[i][2]));
                student.appendChild(email);

                Element phone = document.createElement("phone");
                phone.appendChild(document.createTextNode(studentData[i][3]));
                student.appendChild(phone);
            }

            // Create and write the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("createFile.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);

            System.out.println("File Saved To Specified path!");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
