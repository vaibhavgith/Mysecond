import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Class name first letter must be capital
public class HotelManagementSystem extends JFrame implements ActionListener {

    //Object banvla ki constructor call hoto so
    HotelManagementSystem(){
        setSize(1300,600);
        setLocation(30,100);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1300,600);
        add(image);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,480,850,60);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(1100,480,150,50);
        next.setFont(new Font("serif",Font.PLAIN,40));
        next.setBackground(Color.white);
        next.setForeground(Color.darkGray);
        next.addActionListener(this);
        image.add(next);


        setVisible(true);

        //this is for dipper
        //using multithred method sleep we can hide the text for 500 milisec and again show text using anthor try catch
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    /**
     * this is method overriding but y we do it bcuz when we impliments any interface java concept says we need to override
     * their method or else need to do class abstarct  therefore we override the actionperformed method.
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }


    public static void main(String[] args) {

        new HotelManagementSystem();

    }


}
