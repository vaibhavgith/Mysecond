import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1400,750);
        setVisible(true);

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1400,750);
        add(image);

        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,43));
        text.setForeground(Color.white);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1400,30);
        mb.setBackground(Color.LIGHT_GRAY);
        image.add(mb);

        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.black);
        mb.add(hotel);

        JMenuItem reception=new JMenuItem("RECEPTOIN");
        reception.addActionListener(this);
        hotel.add(reception);



        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.black);

      //  admin.setBackground(Color.blue);
        mb.add(admin);

        JMenuItem addemp=new JMenuItem("ADD EMPLOYEE");
        addemp.addActionListener(this);
        admin.add(addemp);

        JMenuItem addroom=new JMenuItem("ADD ROOMS");
        addroom.addActionListener(this);
        admin.add(addroom);

        JMenuItem adddriver=new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver);




    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (e.getActionCommand().equals("ADD DRIVER")) {
            new AddDriver();

        } else if (e.getActionCommand().equals("RECEPTOIN")) {
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Dashboard();
    }


}
