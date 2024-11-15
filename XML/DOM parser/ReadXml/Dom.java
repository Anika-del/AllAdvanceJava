import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Dom
{
public static void main(String s[])
{
try
{
DocumentBuilderFactory fact1=DocumentBuilderFactory.newInstance(); 
fact1.setValidating(true);
fact1.setIgnoringElementContentWhitespace(true);
DocumentBuilder build1=fact1.newDocumentBuilder();
String book1="book.xml"; 
Document bookdoc=build1.parse(new File(book1));
Element bookele = bookdoc.getDocumentElement();
System.out.println("root"+bookele.getNodeName()+" ");
NodeList chapternodes = bookele.getChildNodes(); 
System.out.println(chapternodes.getLength());

for(int i=0; i<chapternodes.getLength(); i++)
{
Element chapter=(Element) chapternodes.item(i);
System.out.println(chapter.getNodeName()+" ");

NodeList numberlist=chapter.getElementsByTagName("chapNum");
Text number=(Text)numberlist.item(0).getFirstChild();
System.out.println(number.getData()+" ");

NodeList titlelist=chapter.getElementsByTagName("chapTitle");
Text title=(Text)titlelist.item(0).getFirstChild();
System.out.println(title.getData());
}

}catch(Exception e){ System.out.println(e);}
}
}