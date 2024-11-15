import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Rsmd1 {

    public static void main(String[] args) throws Exception {
        Connection conn = getOracleConnection();

       Statement st = conn.createStatement();
       
        st.executeUpdate("drop table survey");
        st.executeUpdate("create table survey (id number(4),name varchar(30))");
        st.executeUpdate("insert into survey (id,name) values (9,'meesa')");
        ResultSet rs = st.executeQuery("SELECT * FROM survey");
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        System.out.println("resultSet MetaData column Count=" + numberOfColumns);

        for (int i = 1; i <= numberOfColumns; i++) {
           // System.out.println("column name "+i+" = "+rsMetaData.getColumnName(i));
           // System.out.println("column type "+i+" = "+rsMetaData.getColumnTypeName(i));
           System.out.println("column metadata ");
           System.out.println("column number ");
           //indicates the designated column's normal maximum width in 
           //characters.
           System.out.println("column name "+rsMetaData.getColumnName(i));
       //gets the designated column's suggested title
       //for use in printouts and displays.
         System.out.println(rsMetaData.getColumnLabel(i));
         //get the designated column's name.
         System.out.println(rsMetaData.getColumnTypeName(i));

         //get the designated column's SQL type
         System.out.println(rsMetaData.getColumnType(i));
         //{Types.INTIGER==z}

         //get thedesignated column's SQL type name
         System.out.println(rsMetaData.getColumnTypeName(i));

         //get thedesignated column's class name
         System.out.println(rsMetaData.getColumnClassName(i));

         //get thedesignated column's table name
         System.out.println(rsMetaData.getTableName(i));

         //get thedesignated column's number of decimal digits name
         System.out.println(rsMetaData.getPrecision(i));

         //get thedesignated column's number of
         //digits to right of the decimal point name
         System.out.println(rsMetaData.getScale(i));

         //indicates wether the destinated column is
         //autometically numbered, thus read-only
         System.out.println(rsMetaData.isAutoIncrement(i));

         //indicates wether the destinated column is a cash value
         System.out.println(rsMetaData.isCurrency(i));

         //indicate wether a write on the designated
         //comumn will succeed
         System.out.println(rsMetaData.isWritable(i));

          //indicate the nullability of values in the designated column
         System.out.println(rsMetaData.isNullable(i));

         //indicate wether the designated column is definetly not writable
         System.out.println(rsMetaData.isReadOnly(i));

         //indicate wether a column's case matters in the designated column
         System.out.println(rsMetaData.isCaseSensitive(i));

         //indicate wether a column's case matters in the designated column
         System.out.println(rsMetaData.isSearchable(i));

         //indicate wether value in the designated colomn are signed numbers
         System.out.println(rsMetaData.isSigned(i));

         //gets the designated column's table catalog name
         System.out.println("catalog name "+ rsMetaData.getCatalogName(i));

         //gets the designated column's table's schema name
         System.out.println("schema name "+ rsMetaData.getSchemaName(i));
        }

        st.close();
        conn.close();
        }
        private static Connection getOracleConnection() throws Exception {

        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
        return c;

    }
}


/*
D:\JDBC\metaData>java Rsmd1
Exception in thread "main" java.sql.SQLException: ORA-00942: table or view does not exist

        at oracle.jdbc.driver.DatabaseError.throwSqlException(DatabaseError.java:112)
        at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:331)
        at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:288)
        at oracle.jdbc.driver.T4C8Oall.receive(T4C8Oall.java:743)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:207)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:946)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1169)
        at oracle.jdbc.driver.OracleStatement.executeUpdateInternal(OracleStatement.java:1615)
        at oracle.jdbc.driver.OracleStatement.executeUpdate(OracleStatement.java:1580)
        at Rsmd1.main(Rsmd1.java:14)*/