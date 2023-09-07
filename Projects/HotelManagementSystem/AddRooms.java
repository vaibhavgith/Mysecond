import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfroom,tfprice;

    JComboBox typecombo,availabelcombo,cleancombo;

    AddRooms(){

        JLabel heading =new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblrooms =new JLabel("Room Number");
        lblrooms.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblrooms.setBounds(60,80,120,30);
        add(lblrooms);

         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailabel =new JLabel("Available");
        lblavailabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailabel.setBounds(60,130,120,30);
        add(lblavailabel);

        String availabeloption[]={"Available","Occupied"};
         availabelcombo=new JComboBox(availabeloption);
        availabelcombo.setBounds(200,130,150,30);
        availabelcombo.setBackground(Color.white);
        add(availabelcombo);

        JLabel lblclean =new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanoption[]={"Clean","Dirty"};
         cleancombo=new JComboBox(cleanoption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        JLabel lblprice =new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

         tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lbltype =new JLabel("Cleaning Status");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeoption[]={"Single Bed","Double Bed"};
         typecombo=new JComboBox(typeoption);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);

         add =new JButton("Add Room");
        add.setBounds(60,350,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

         cancel =new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);






        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(200,200,940,470);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String roomnumber=tfroom.getText();
            String availability=(String) availabelcombo.getSelectedItem();
            String status=(String) cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String type=(String) typecombo.getSelectedItem();

            try{
                Conn conn=new Conn();

                String str="insert into hotelmanagementsystem.room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";

                conn.st.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room Added Succesfully");

                setVisible(false);

            }catch (Exception ea){
                System.out.println(ea);
            }





        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRooms();
    }


}
