import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;

    JComboBox typecombo,cleancombo;

    AddDriver(){

        JLabel heading =new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblrooms =new JLabel("Name");
        lblrooms.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblrooms.setBounds(60,80,120,30);
        add(lblrooms);

        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblavailabel =new JLabel("Age");
        lblavailabel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailabel.setBounds(60,130,120,30);
        add(lblavailabel);

        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);



        JLabel lblclean =new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanoption[]={"Male","Female"};
        cleancombo=new JComboBox(cleanoption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        JLabel lblprice =new JLabel("Car Company");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        tfcompany=new JTextField();
        tfcompany.setBounds(200,230,150,30);
        add(tfcompany);

        JLabel lbltype =new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);

        JLabel available =new JLabel("Availability");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,330,120,30);
        add(available);

        String typeoption[]={"Available","Busy"};
        typecombo=new JComboBox(typeoption);
        typecombo.setBounds(200,330,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);

        JLabel location =new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        location.setBounds(60,380,120,30);
        add(location);

        tflocation=new JTextField();
        tflocation.setBounds(200,380,150,30);
        add(tflocation);



        add =new JButton("Add Driver");
        add.setBounds(500,380,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        cancel =new JButton("Cancel");
        cancel.setBounds(700,380,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);






        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(200,170,980,500);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) cleancombo.getSelectedItem();
            String company=tfcompany.getText();
            String model=tfmodel.getText();
            String availble=(String) typecombo.getSelectedItem();
            String location=tflocation.getText();

            try{
                Conn conn=new Conn();

                String str="insert into hotelmanagementsystem.driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availble+"','"+location+"')";

                conn.st.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Driver Added Succesfully");

                setVisible(false);

            }catch (Exception ea){
                System.out.println(ea);
            }





        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddDriver();
    }


}
