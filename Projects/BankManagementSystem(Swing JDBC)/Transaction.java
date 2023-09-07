import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposite,withdraw,fastcash,minst,pinchange,balnce,exit;

    String pinnum;

     Transaction(String pinnum){

         this.pinnum=pinnum;

         setLayout(null);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(780,780, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,780,780);
         add(image);

         JLabel text=new JLabel("Please Select Your Transaction");
         text.setBounds(180,260,700,35);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,14));
         image.add(text);

          deposite=new JButton("Deposite");
         deposite.setBounds(140,360,120,25);
         deposite.addActionListener(this);
         image.add(deposite);

          withdraw=new JButton("Cash WithDrawl");
         withdraw.setBounds(320,360,120,25);
         withdraw.addActionListener(this);
         image.add(withdraw);

          fastcash=new JButton("FastCash");
         fastcash.setBounds(140,390,120,25);
         fastcash.addActionListener(this);
         image.add(fastcash);

          minst=new JButton("Mini Statement");
         minst.setBounds(320,390,120,25);
         minst.addActionListener(this);
         image.add(minst);

          pinchange=new JButton("PinChange");
         pinchange.setBounds(140,420,120,25);
         pinchange.addActionListener(this);
         image.add(pinchange);

          balnce=new JButton("BalanceENQ");
         balnce.setBounds(320,420,120,25);
         balnce.addActionListener(this);
         image.add( balnce);

          exit=new JButton("Exit");
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
             System.exit(0);
         } else if (e.getSource()==deposite) {
             setVisible(false);
             new Deposite(pinnum).setVisible(true);

         } else if (e.getSource()==withdraw) {
             setVisible(false);
             new Withdrawl(pinnum).setVisible(true);

         } else if (e.getSource()==fastcash) {
             setVisible(false);
             new Fastcash(pinnum).setVisible(true);

         } else if (e.getSource()==pinchange) {
             setVisible(false);
             new Pinchange(pinnum).setVisible(true);
         } else if (e.getSource()==balnce) {
             setVisible(false);
             new BalanceEnq(pinnum).setVisible(true);
         } else if (e.getSource()==minst) {
             new MinStatement(pinnum).setVisible(true);

         }


    }

    public static void main(String[] args) {
         new Transaction("");

    }


}
