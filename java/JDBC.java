import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


class main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaibhav", "root", "Vaibhav@15");

            Statement st=con.createStatement();
           int  count =st.executeUpdate("insert into nevase (fathers_id) values (65);");
            System.out.println("affected = "+count);

//            ResultSet rs=st.executeQuery("create table vaibhav");
//            rs.next();
            System.out.println("succesfully done");
//            return con;
            con.close();

        } catch (Exception e) {
            System.out.println("done "+e);


        }
    }
}
