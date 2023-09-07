import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nametext,fnametext,emailtext,addressltext,cityltext,statetext,pintext;
    JButton next;
    JRadioButton male,female,other,maried,unmaried;
    JDateChooser date;



    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L );

        JLabel formno=new JLabel("Application Form No."+ random  );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails=new JLabel("Page 1: Personal Details."  );
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name:"  );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

         nametext=new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        nametext.setBounds(300,140,400,30);
        add(nametext);

        JLabel fname=new JLabel("Fathers Name:"  );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametext=new JTextField();
        fnametext.setFont(new Font("Raleway",Font.BOLD,14));
        fnametext.setBounds(300,190,400,30);
        add(fnametext);

        JLabel dob=new JLabel("Date Of Birth:"  );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        date=new JDateChooser();                  //for calender
        date.setBounds(300,240,400,30);
        date.setForeground(new Color(105,105,105));
        add(date);

        JLabel gender=new JLabel("Gender:"  );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");       //for radio buttons
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup grp=new ButtonGroup();                    //With this we can select only one button
        grp.add(male);
        grp.add(female);

        JLabel email=new JLabel("Email Address:"  );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailtext=new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
        emailtext.setBounds(300,340,400,30);
        add(emailtext);

        JLabel marital=new JLabel("Marital Status:"  );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        maried=new JRadioButton("Married");       //for radio buttons
        maried.setBounds(300,390,100,30);
        maried.setBackground(Color.white);
        add(maried);
        unmaried=new JRadioButton("Unmarried");
        unmaried.setBounds(450,390,100,30);
        unmaried.setBackground(Color.white);
        add(unmaried);
        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup grp1=new ButtonGroup();                 //With this we can select only one button
        grp1.add(maried);
        grp1.add(unmaried);
        grp1.add(other);

        JLabel address=new JLabel("Address:"  );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        addressltext=new JTextField();
        addressltext.setFont(new Font("Raleway",Font.BOLD,14));
        addressltext.setBounds(300,440,400,30);
        add(addressltext);

        JLabel city=new JLabel("City:"  );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        cityltext=new JTextField();
        cityltext.setFont(new Font("Raleway",Font.BOLD,14));
        cityltext.setBounds(300,490,400,30);
        add(cityltext);

        JLabel state=new JLabel("State:"  );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        statetext=new JTextField();
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        statetext.setBounds(300,540,400,30);
        add(statetext);

        JLabel pin=new JLabel("Pin Code:"  );
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);
        pintext=new JTextField();
        pintext.setFont(new Font("Raleway",Font.BOLD,14));
        pintext.setBounds(300,590,400,30);
        add(pintext);

        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno= " " + random;  //To convert long into String use " " +
        String name=nametext.getText(); //with the help of getText() function we can get value inside the nametext
        String fname=fnametext.getText();
        String dob =((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";

        }

        String email=emailtext.getText();
        String marital=null;
        if(maried.isSelected()){
            marital="Married";
        } else if (unmaried.isSelected()) {
            marital="Unmarried";
        } else if (other.isSelected()) {
            marital="Other";
        }

        String address=addressltext.getText();
        String city=cityltext.getText();
        String state=statetext.getText();
        String pin=pintext.getText();

        try{
            if(name.equals("")){
                //this is validation if name box is empty then it will show pop us msssg as written
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                /*
                this is where we attachec the sql connectioon
                 */
                Conn cn=new Conn();
                // with the help of below querry we ARE storing our values in database.
                String q1 = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";

                cn.st.executeUpdate(q1);


                new SignupTwo(formno).setVisible(true);  //new page will open after clicking next button
                setVisible(false);                // form will be close after clicking next button

            }
        }catch (Exception e){
            System.out.println(e);

        }


    }

    public static void main(String[] args) {

        new SignupOne();
    }


}
