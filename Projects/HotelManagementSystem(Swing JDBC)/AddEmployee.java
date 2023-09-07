import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfadhar;
    JRadioButton rbmale,rbfemale;
     JButton submit;

     JComboBox job;
    AddEmployee(){
        setLayout(null);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

         tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

         tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add( tfage);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        rbmale=new JRadioButton("Male");
       rbmale.setBounds(200,130,70,30);
       rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
       rbmale.setBackground(Color.white);
       add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();   //this is for selecting only one value
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        String str[]={"Front Desk Clerks","Porters","Room Service","Chief","Kitchen Staff","Waiter","HouseKipping","Manager"};
         job=new JComboBox(str);
        job.setBounds(200,180,150,30);
        job.setBackground(Color.white);
        add(job);

        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);

         tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add( tfsalary);

        JLabel lblphone=new JLabel("PHONE NO.");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

         tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add( tfphone);

        JLabel lblemail=new JLabel("EMAIL.");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

         tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add( tfemail);

        JLabel lbladhar=new JLabel("ADHAR NO.");
        lbladhar.setBounds(60,380,120,30);
        lbladhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbladhar);

        tfadhar=new JTextField();
        tfadhar.setBounds(200,380,150,30);
        add( tfadhar);

        submit=new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma",Font.PLAIN,17));
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,350);
        add(image);


        getContentPane().setBackground(Color.white); //for background color
        setBounds(260,175,850,540);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=tfname.getText(); //this values from Jtextfield
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String adhar=tfadhar.getText();

        String gender=null;
        if (rbmale.isSelected()){             //this is for radiobutton values
            gender="Male";
        } else if (rbfemale.isSelected()) {
            gender="Female";
        }

        String Ejob=(String) job.getSelectedItem();  //this is for combobox,(String) this is typecasting bcuz getSelelcetd method
                                                      // returns object value but we stored this in String Value(Ejob) that's y we did
                                                      // typecast.


        try{ //whenever we want to connect database first create conn object
            Conn conn=new Conn();  //step1
            //then create query
            String query4="insert into hotelmanagementsystem.employee values('"+name+"','"+age+"','"+gender+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')";

            conn.st.executeUpdate(query4);

            JOptionPane.showMessageDialog(null,"Employee Added Succesfully ");
            setVisible(false);

        }catch (Exception em){
            System.out.println(em);
        }



    }

    public static void main(String[] args) {
        new AddEmployee();
    }


}
