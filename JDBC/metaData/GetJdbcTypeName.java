import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetJdbcTypeName {

public static void main(String[] argv) throws Exception {

    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
    DatabaseMetaData dbmd = conn.getMetaData();
   ResultSet resultSet = dbmd.getTypeInfo();

    while (resultSet.next()) {
        String typeName = resultSet.getString("TYPE_NAME");

        short dataType = resultSet.getShort("DATA_TYPE");
        System.out.println(typeName + "=" + dataType);
    }
}}


/*
D:\JDBC\metaData>java GetJdbcTypeName
INTERVALDS=-104
INTERVALYM=-103
TIMESTAMP WITH LOCAL TIME ZONE=-102
TIMESTAMP WITH TIME ZONE=-101
NUMBER=-7
NUMBER=-6
NUMBER=-5
LONG RAW=-4
RAW=-3
LONG=-1
CHAR=1
NUMBER=2
NUMBER=4
NUMBER=5
FLOAT=6
REAL=7
VARCHAR2=12
DATE=91
DATE=92
TIMESTAMP=93
STRUCT=2002
ARRAY=2003
BLOB=2004
CLOB=2005
REF=2006

*/
