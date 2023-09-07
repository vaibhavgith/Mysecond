import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DisplayRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    DisplayRoom(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Available ");
        l2.setBounds(120,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(200,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);

        JLabel l5=new JLabel("BedType");
        l5.setBounds(410,10,100,20);
        add(l5);

        table =new JTable();  ///this is for creating table in dashboard
        table.setBounds(0,40,500,400);
        add(table);

        try {
            Conn conn=new Conn();
            ResultSet rs =conn.st.executeQuery("select * from hotelmanagementsystem.room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);





        setLayout(null);
        setBounds(175,100,1050,600);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public static void main(String[] args) {
        new DisplayRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();

    }
}
