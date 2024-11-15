import java.sql.*;

class MySqlCon {

    public static void main(String[] args) {
        
        try{

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "root");

            Statement st = c.createStatement();
            String query = "Select * from student";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getString(1)+ " " +rs.getString(2));
            }
            c.close();
            
        }catch(SQLException e){
            System.out.println("error");
    }catch(Exception e){ }
 
}
}