import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.ResultSet;

public class MinStatement extends JFrame {

    MinStatement(String pinnum){
        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn=new Conn();
            ResultSet rs= conn.st.executeQuery("select *  from login where pin = '"+pinnum+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("pin").substring(0,4)+"xxxxxx");

            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.st.executeQuery("select * from bank where pin= '"+pinnum+"'");
            while (rs.next()){
               mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposite")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Balance is Rs "+bal);
        }
        catch (Exception em){
            System.out.println(em);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MinStatement("");
    }
}
