import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory fact1=DocumentBuilderFactory.newInstance();
            fact1.setValidating(true);
            fact1.setIgnoringElementContentWhitespace(true);
            DocumentBuilder build1=fact1.newDocumentBuilder();
            String book1="jdbc.xml";
            Document doc=build1.parse(new File(book1));
			

            NodeList tableList = doc.getElementsByTagName("OracleData");
            Node tableNode = tableList.item(0);

            if (tableNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tableElement = (Element) tableNode;


                String driver = tableElement.getElementsByTagName("driver").item(0).getTextContent();
                String url = tableElement.getElementsByTagName("url").item(0).getTextContent();
                String username = tableElement.getElementsByTagName("username").item(0).getTextContent();
                String password = tableElement.getElementsByTagName("pass").item(0).getTextContent();
                String tableName = tableElement.getElementsByTagName("tablename").item(0).getTextContent();

                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                String query = "SELECT * FROM " + tableName;
                ResultSet rs = stmt.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                while(rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                    }
                    System.out.println();
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
