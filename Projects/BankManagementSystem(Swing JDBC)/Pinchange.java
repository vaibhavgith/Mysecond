import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnum;

    Pinchange(String pinnum){
        this.pinnum=pinnum;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(780,780,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        JLabel text=new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(220,260,700,35);
        image.add(text);



        JLabel pintext=new JLabel("New Pin");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,14));
        pintext.setBounds(140,290,700,35);
        image.add(pintext);

         pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(240,290,200,25);
        image.add(pin);

        JLabel retext=new JLabel("Re-Enter Pin");
        retext.setForeground(Color.white);
        retext.setFont(new Font("System",Font.BOLD,14));
        retext.setBounds(140,320,700,35);
        image.add(retext);

         repin =new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        repin.setBounds(240,320,200,25);
        image.add(repin);

         change=new JButton("Change");
        change.setBounds(300,415,150,30);
        change.addActionListener(this);
        image.add(change);

         back=new JButton("Back");
        back.setBounds(300,450,150,30);
        back.addActionListener(this);
        image.add(back);






        setSize(780,780);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Not Matched");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please  re-Enter Pin");
                    return;
                }
                Conn conn=new Conn();
                String query1="update bank set pin='"+rpin+"' where pin='"+pinnum+"'";
                String query2="update login set pin='"+rpin+"' where pin='"+pinnum+"'";
                String query3="update signupthree set pin='"+rpin+"' where pin='"+pinnum+"'";

                conn.st.executeUpdate(query1);
                conn.st.executeUpdate(query2);
                conn.st.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed succesfully ");

                setVisible(false);
                new Transaction(rpin).setVisible(true);




            } catch (Exception ep) {
                System.out.println(ep);
            }
        }
        else{
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }


    }

    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }


}
