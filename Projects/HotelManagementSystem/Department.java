import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){



        JLabel l1=new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Budegt ");
        l2.setBounds(370,10,100,20);
        add(l2);



        table =new JTable();  ///this is for creating table in dashboard
        table.setBounds(0,50,700,400);
        add(table);

        try {
            Conn conn=new Conn();
            ResultSet rs =conn.st.executeQuery("select * from hotelmanagementsystem.department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(250,500,120,30);
        back.addActionListener(this);
        add(back);





        setLayout(null);
        setBounds(175,100,700,600);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();

    }
}
