import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){

        this.formno=formno;

        setLayout(null);   // setlayout need to be null to work setBounds
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,20,400,40);
        add(l1);

        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,110,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,150,250,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,150,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,190,250,20);
        add(r3);

        r4=new JRadioButton("Recurring Account ");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,190,250,20);
        add(r4);

        ButtonGroup grp1=new ButtonGroup();
        grp1.add(r1);
        grp1.add(r2);
        grp1.add(r3);
        grp1.add(r4);

        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,250,300,30);
        add(card);

        JLabel cnumber=new JLabel("XXXX-XXXX-XXXX-1234");
        cnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cnumber.setBounds(330,250,300,30);
        add(cnumber);
        JLabel cdetail=new JLabel("Your 16 Digit Card Number");
        cdetail.setFont(new Font("Raleway",Font.BOLD,12));
        cdetail.setBounds(100,280,300,20);
        add(cdetail);

        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,330,300,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,330,200,30);
        add(pnumber);

        JLabel pdetail=new JLabel("Your 4 Digit Password");
        pdetail.setFont(new Font("Raleway",Font.BOLD,12));
        pdetail.setBounds(100,360,300,20);
        add(pdetail);

        JLabel services=new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,400,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,450,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking ");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,450,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,500,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,500,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,550,200,30);
        add(c5);

        c6=new JCheckBox("E Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,550,200,30);
        add(c6);

        c7=new JCheckBox("I here By declare that above deatils are correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,600,600,30);
        add(c7);


      submit=new JButton("Submit");
      submit.setBackground(Color.black);
      submit.setForeground(Color.white);
      submit.setFont(new Font("Raleway",Font.BOLD,14));
      submit.setBounds(250,660,100,30);
      submit.addActionListener(this);
      add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,660,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);


        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accounttype=null;
            if (r1.isSelected()){
                accounttype="Saving Account";
            } else if (r2.isSelected()) {
                accounttype="Fixed Deposite";

            } else if (r3.isSelected()) {
                accounttype="current account";

            } else if (r4.isSelected()) {
                accounttype="recurring account";

            }

            Random ran=new Random();
            String cnum=" " + Math.abs((ran.nextLong()%90000000L)+50401236500000000L);

            String pnum=" " + Math.abs((ran.nextLong()%9000L)+1000L);

            String facility="";
            if (c1.isSelected()){
                facility=facility+"Atm Card";
            } else if (c2.isSelected()) {
                facility+="Internet Banking";

            } else if (c3.isSelected()) {
                facility+="Mobile banking";

            } else if (c4.isSelected()) {
                facility+="email and sms";
            } else if (c5.isSelected()) {
                facility+=" Cheque Book";
            } else if (c6.isSelected()) {
                facility+="E Statement";
            }
            try{
                if (accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type Required");
                } else {
                    Conn con=new Conn();

                    String q32 = "insert into login values('" + formno + "','" + cnum + "','" + pnum + "')";
                    con.st.executeUpdate(q32);

                    JOptionPane.showMessageDialog(null,"Card Number:"+cnum+"\npin: "+pnum);

                    String q3 = "insert into signupthree values('" + formno + "','" + accounttype + "','" + cnum + "','" + pnum + "','" + facility + "')";

                    con.st.executeUpdate(q3);

                    setVisible(false);
                    /// there is bug here
                    new Deposite(pnum).setVisible(false);




                }

            }catch (Exception e3){
                System.out.println(e3);
            }


        } else if (e.getSource()==cancel) {

            setVisible(false);
            new Login().setVisible(true);


        }

    }

    public static void main(String[] args) {
        new SignupThree("");
    }


}
