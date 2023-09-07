import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawl,back;


    String pinnum;
    Withdrawl(String pinnum){
        this.pinnum=pinnum;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(780,780,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,780,780);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(160,260,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);

        amount  =new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setBounds(160,290,280,25);
        image.add(amount);

        withdrawl =new JButton("Withdrawl");
        withdrawl.setBounds(300,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back =new JButton("Back");
        back.setBounds(300,450,150,30);
        back.addActionListener(this);
        image.add(back);






        setSize(780,780);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==withdrawl){
            String number=amount.getText();
            Date date=new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");

            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "Insert into bank values('" + pinnum + "','" + date + "','Withdrawl','" + number + "')";
                    conn.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " +number+" Withdrawl succesfully");
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
                catch (Exception ed){
                    System.out.println(ed);
                }
            }


        }
        else if (e.getSource()==back){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);

        }

    }


    public static void main(String[] args) {
        new Withdrawl("");

    }


}
