import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField username,password;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.white);

        setLayout(null);

        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password=new JTextField();
        password.setBounds(150,70,150,30);
        add(password);

        login =new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel =new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2); //why created i3 bcuz we cant put directly image class object into jlabel thats y we created new
        //imageicon object
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(450,200,600,300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==login){
            String user= username.getText();  //with the help of gettext() method we can achieve the values from login pass
            String pass=password.getText();

            /**
             * error occuring as class not found and null pointer exception maybe
             * need to load mysql file again in system
             */

            try{
                Conn c=new Conn();
                //this is sql query we are hitting to mysql
                //here we use single quotes bcuz in sql datatype is varchar nd there we use single quotes therefore
                String query=  "SELECT * FROM hotelmanagementsystem.login " ;
                //where username =  ' " + user + " '  and password = ' " + pass + " ' ";
                //we use resultset bcuz we have to return anything to store this we store into resultset
                ResultSet rs = c.st.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new Dashboard().setVisible(true);
                }
                else{
                    //joptionpane for pop up message on screen
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }


            }catch (Exception el){
                System.out.println(el);
            }

        } else if (e.getSource()==cancel) {
            setVisible(false);
        }

    }


    public static void main(String[] args) {
        new Login();

    }


}
