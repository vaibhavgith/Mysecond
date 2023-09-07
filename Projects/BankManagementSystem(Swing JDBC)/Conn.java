import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 class Conn {
    Connection c;
    Statement st;

    public Conn(){
        /*
        Why we use exceptional handling in jdbc == because MySql is external entity so there
        are chances of getting errors at runtime so for catching that error we use exceptional
        handling
         */
        try{
            //1st step= class
            Class.forName("com.mysql.cj.jdbc.Driver" );
            //2 - step = Create a Connection
            this.c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Vaibhav@15");
            //3rd step == Create statement
           this.st=this.c.createStatement();



        }catch (Exception ce){
            System.out.println(ce);

        }
    }
}
