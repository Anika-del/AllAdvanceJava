/*
 Seeing External Changes in a ResultSet

 Only scrollable resultset can see external changes to the underlying database, and it can only see thechanges from 
 external UPDATE operations. Changes from external DELETE operations are never visiable.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class SensitiveResultSet {

    public static void main(String a[]) {

        Statement st = null;
        Statement st1 = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");

            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("supports HOLD_CURSORS_OVER_COMMIT? "+ dbmd.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
            // Create a scroll-sensitive ResultSet
            boolean b = dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
            System.out.println("supports TYPE_SCROLL_SENSITIVE? "+ b);

            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
            st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           st.setFetchSize(1);


           MyThread1 t1 = new MyThread1(st,st1);
           t1.start();

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
class MyThread1 extends Thread {
    Statement st;
    Statement st1;
    ResultSet rs;
    MyThread1(Statement st, Statement st1) {
        this.st = st;
        this.st1 = st1;
    }
    public void run() {
        try {
            rs = st.executeQuery("select accno, bal from bank1");
            while(rs.next()){
            System.out.println("accno"+ rs.getString(1)+"=");
            System.out.println("bal"+ rs.getString(2));
            System.out.println("  ");
        }
        MyThread2 t2 = new MyThread2(st1);
        t2.start();

        try{
            t2.join();
        }catch (Exception e){ }
            rs.beforeFirst();
            System.out.println("after changes ");

            while(rs.next()){
            System.out.println("accno"+ rs.getString(1)+"=");
            System.out.println("bal"+ rs.getString(2));
            System.out.println("  ");
            }
        }catch(Exception e){ System.out.println(e);}
    }
    }

class MyThread2 extends Thread {

    Statement st;
    MyThread2(Statement st) {
        this.st = st;
    }
    public void run() {

        try {
            st.execute("UPDATE bank1 SET bal + 500 ");
            st.execute("COMMIT");   
            st.close();
            System.out.println("Record Updated");
            Thread.sleep(1000);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

    









           