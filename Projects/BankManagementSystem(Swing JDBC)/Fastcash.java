import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class Fastcash extends JFrame implements ActionListener {

    JButton deposite,withdraw,fastcash,minst,pinchange,balnce,exit;

    String pnum;

    Fastcash(String pnum){

        this.pnum=pnum;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(780,780, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        JLabel text=new JLabel(" Select Your Withdrwal amount ");
        text.setBounds(180,260,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);

        deposite=new JButton("Rs 100");
        deposite.setBounds(140,360,120,25);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw=new JButton("Rs 500");
        withdraw.setBounds(320,360,120,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(140,390,120,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minst=new JButton("Rs 2000");
        minst.setBounds(320,390,120,25);
        minst.addActionListener(this);
        image.add(minst);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(140,420,120,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balnce=new JButton("Rs 10000");
        balnce.setBounds(320,420,120,25);
        balnce.addActionListener(this);
        image.add( balnce);

        exit=new JButton("Back");
        exit.setBounds(320,450,120,25);
        exit.addActionListener(this);
        image.add( exit);

        setSize(780,780);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            setVisible(false);
            new Transaction(pnum).setVisible(true);
        } else  {
           String amount = ((JButton) e.getSource()).getText().substring(3);
           Conn conn=new Conn();
           try
           {
               ResultSet rs=conn.st.executeQuery("Select * from bank where pin='"+pnum+"'");
               int balance=0;
               while(rs.next()){
                   if (rs.getString("type").equals("Deposite")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }

               if (e.getSource()!=exit && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insuffucient Balance");
                   return;
               }

               Date date=new Date();
               String query="insert into bank values('"+pnum+"','"+date+"','Withdrwal','"+amount+"')";
               conn.st.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs" + amount + " Debited Succesfully");

               setVisible(false);
               new Transaction(pnum).setVisible(true);


           }
           catch (Exception  ef){
               System.out.println(ef);
           }

        }


    }

    public static void main(String[] args) {
        new Fastcash("");

    }


}
