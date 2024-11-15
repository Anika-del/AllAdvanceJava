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

public class CreateXml
{
public static void main(String args[ ]){

try{
  
     DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	 
	 
	 //define root elements
	 Document document = documentBuilder.newDocument();
	 Element rootElement = document.createElement("school");
	 document.appendChild(rootElement);
	 
	 
	 //define school elements
	 Element student = document.createElement("Student");
	 rootElement.appendChild(student);
	 
	 
	 //add attributes to school
	 Attr attribute = document.createAttribute("id");
	 attribute.setValue("1");
	 student.setAttributeNode(attribute);
	 
	 //firstname elements
	 Element firstname = document.createElement("firstname");
	 firstname.appendChild(document.createTextNode("ankush"));
	 student.appendChild(firstname);
	 
	 //lastname elements
	  Element lastname=document.createElement("lastname");
	 lastname.appendChild(document.createTextNode("thakur"));
	 student.appendChild(lastname);
	 
	 //email elements
	 Element email = document.createElement("email");
	 email.appendChild(document.createTextNode("abc@gmail.com"));
	 student.appendChild(email);
	 
	 //phone elements
	 Element phone = document.createElement("phone");
	 phone.appendChild(document.createTextNode("8081362908"));
	 student.appendChild(phone);
	 
	 //creating and writing xml file
	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 Transformer transformer = transformerFactory.newTransformer();
	 DOMSource domSource = new DOMSource(document);
	 StreamResult streamResult = new StreamResult(new File("createFile.xml"));
	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	 transformer.transform(domSource, streamResult);
	 
	 System.out.println("File Saved To Specified path!");
	 
	 
	 }catch(ParserConfigurationException pce){
	 pce.printStackTrace();
	 }catch(TransformerException tfe){
	 tfe.printStackTrace();
	 }
  }
}
	 
/*Create_XML_By_Java_Code>javac CreateXml.java

Create_XML_By_Java_Code>java CreateXml
File Saved To Specified path!


*/
	 