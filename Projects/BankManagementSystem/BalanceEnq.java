import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ScatteringByteChannel;
import java.sql.ResultSet;

public class BalanceEnq extends JFrame implements ActionListener {
    JButton back;

    String pinnum;
    BalanceEnq(String pinnum){
        this.pinnum=pinnum;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(780,780,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        back=new JButton("Back");
        back.setBounds(300,450,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn conn=new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.st.executeQuery("select * from bank where pin='" + pinnum + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Current Account Balance Rs "+balance);
        text.setForeground(Color.white);
        text.setBounds(150,260,700,35);
        image.add(text);





        setSize(780,780);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinnum).setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnq("");
    }


}
