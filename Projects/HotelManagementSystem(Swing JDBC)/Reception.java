import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newcustomer, rooms,depatement;
    Reception(){

         newcustomer=new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.black);
        newcustomer.setForeground(Color.white);
        newcustomer.addActionListener(this);
        add(newcustomer);

         rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

         depatement=new JButton("Depatement");
        depatement.setBounds(10,110,200,30);
        depatement.setBackground(Color.black);
        depatement.setForeground(Color.white);
        depatement.addActionListener(this);
        add(depatement);

        JButton allemp=new JButton("All Employee");
        allemp.setBounds(10,150,200,30);
        allemp.setBackground(Color.black);
        allemp.setForeground(Color.white);
        add(allemp);

        JButton Customers=new JButton("Customer info");
        Customers.setBounds(10,190,200,30);
        Customers.setBackground(Color.black);
        Customers.setForeground(Color.white);
        add(Customers);

        JButton manager=new JButton("Manager info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        add(manager);

        JButton checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        add(checkout);

        JButton update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        add(update);

        JButton roomstatus=new JButton("Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.black);
        roomstatus.setForeground(Color.white);
        add(roomstatus);

        JButton pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        add(pickup);

        JButton searchroom=new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        add(searchroom);

        JButton logout=new JButton("LogOut");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(250,120,800,570);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newcustomer){
            new AddCustomer();
            setVisible(false);
        } else if (e.getSource()==rooms) {
            setVisible(false);
            new DisplayRoom();
        } else if (e.getSource()==depatement) {
            setVisible(false);
            new Department();
        }

    }

    public static void main(String[] args) {
        new Reception();
    }


}
