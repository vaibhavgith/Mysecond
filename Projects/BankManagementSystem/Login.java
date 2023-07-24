import javax.swing.*;
//import javax.swing.*;
import java.awt.*;  // we imported this pakage bcuz of Image class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//inheritance used here as extends jframe
//
public class Login extends JFrame implements ActionListener {

    //By defining buttons and textfield  " GLOBALLY   we can access this buttons and there actions anywhere in the
    // program or other function.
    JButton login,clear,signup;
    JTextField cardtext;
    JPasswordField pintext;

    Login(){

        setTitle("ATM");
        setLayout(null);

        //Icons
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  // when we want to add img use this also
                                   //classLoader for any file want to load in project
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);   // we crated this object bcuz we cant add image directly into label class we need to convert
                                           //it into icon class so we can add
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.white);    //to set background color

        //Text
        JLabel text=new JLabel("Welcome To ATM");   //Use Jlabel for writting on frame(window)
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        // Card No
        JLabel cardNo=new JLabel("Card No: ");             //Use Jlabel for writting on frame(window)
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
         // Card text field
        cardtext=new JTextField();
        cardtext.setBounds(300,150,230,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtext);

        //PIN
        JLabel Pin=new JLabel("PIN: ");   //Use Jlabel for writting on frame(window)
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        Pin.setBounds(120,220,250,30);
        add(Pin);
         //pin text field
        pintext=new JPasswordField();
        pintext.setBounds(300,220,230,30);
        pintext.setFont(new Font("Arial",Font.BOLD,14));
        add(pintext);



        //Buttons
        //here we also defined as locally so there is not necceesary to mention JButton class bcuz we already defined them
        //as globally above (line 14)
        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);   //TEXT color on button
        login.addActionListener(this);    //for accepting values or to perform actions
        add(login);

        clear =new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);   //TEXT color on button
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);   //TEXT color on button
        signup.addActionListener(this);
        add(signup);

        add(label);                     // When we want to pass any component on frame then use add method
        setSize(800,480);  //defines the size of the frame(window).
        setVisible(true);
        setLocation(300,180);

    }
    /**
     * what is the use of below function == when we click the button what action
     * should button take is defined in this function
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        We use getSource method for select specific button where we want to add actions
        Define Jtextfield globally
         */
        if (e.getSource() == clear){
           cardtext.setText("");
           pintext.setText("");

        } else if (e.getSource() == login) {


            Conn conn=new Conn();
            String cnum=cardtext.getText();
            String pnum=pintext.getText();

            // there is a bug here
            //bug must be at query or in sql table names


            String query="select * from login " ;
               //     "where  cardnum = '"+cnum+"' and pin = '"+pnum+"'";
            try{
//                String query1 = query;
                ResultSet rs = conn.st.executeQuery(query);
               if (rs.next())
               {
                   setVisible(false);
                   new Transaction(pnum).setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Password");

               }

            }catch (Exception el){
                System.out.println(el);
            }


        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);


        }
    };
    public static void main(String[] args) {
        //this is object  of the class so when we run the program as soon as constructor run we got frame from object
        new Login();
    }
}
