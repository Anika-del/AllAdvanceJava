import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class DataBaseInfo {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
        DatabaseMetaData mtdt = conn.getMetaData();
        System.out.println("URL in use: " + mtdt.getURL());
        System.out.println("User name: " + mtdt.getUserName());
        System.out.println("DBMS name: " + mtdt.getDatabaseProductName());
        System.out.println("DBMS version: " + mtdt.getDatabaseProductVersion());
        System.out.println("Driver name: " + mtdt.getDriverName());
        System.out.println("Driver version: " + mtdt.getDriverVersion());
        System.out.println("supp. SQL Keywords: " + mtdt.getSQLKeywords());
        conn.close();
    }
}

/*
D:\JDBC\metaData>java DataBaseInfo
URL in use: jdbc:oracle:thin:@localhost:1521:xe
User name: SYSTEM
DBMS name: Oracle
DBMS version: Oracle Database 10g Express Edition Release 10.2.0.1.0 - Production
Driver name: Oracle JDBC driver
Driver version: 10.2.0.1.0XE
supp. SQL Keywords: ACCESS, ADD, ALTER, AUDIT, CLUSTER, COLUMN, COMMENT, COMPRESS, CONNECT, DATE, 
DROP, EXCLUSIVE, FILE, IDENTIFIED, IMMEDIATE, INCREMENT, INDEX, INITIAL, INTERSECT, LEVEL, LOCK, 
LONG, MAXEXTENTS, MINUS, MODE, NOAUDIT, NOCOMPRESS, NOWAIT, NUMBER, OFFLINE, ONLINE, PCTFREE, PRIOR,
 all_PL_SQL_reserved_ words
 */