
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;




public class SignupTwo extends JFrame implements ActionListener{

  //  long random;
    JTextField pan,Adhar;
    JButton next;
    JRadioButton en,scy,scn,ey;
    JDateChooser date;
    JComboBox religion,Category,income,edu,Occupation;

    String formno;




    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
//        Random ran=new Random();
//        random = (Math.abs(ran.nextLong() % 9000L) + 1000L );
        setTitle("New Account Application Form - Page 2");

//        JLabel formno=new JLabel("Application Form No." );
//        formno.setFont(new Font("Raleway",Font.BOLD,38));
//        formno.setBounds(140,20,600,40);
//        add(formno);

        JLabel AdditionalDetails=new JLabel("Page 2: Additional Details."  );
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);

        JLabel name=new JLabel("Religion:"  );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);

        add(name);

        String varReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(varReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

//        nametext=new JTextField();
//        nametext.setFont(new Font("Raleway",Font.BOLD,14));
//        nametext.setBounds(300,140,400,30);
//        add(nametext);

        JLabel fname=new JLabel("Category:"  );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String varCatogry[]={"Genral","OBC","VJNT","SC/ST","Other"};
         Category=new JComboBox(varCatogry);
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.white);
        add(Category);

        JLabel dob=new JLabel("Income:"  );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String IncomeCatogry[]={"Null","<1,50,000","<2,50,000","<500000","Upto 1000000"};
        income=new JComboBox(IncomeCatogry);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

//        date=new JDateChooser();                  //for calender
//        date.setBounds(300,240,400,30);
//        date.setForeground(new Color(105,105,105));
//        add(date);

        JLabel gender=new JLabel("Educational"  );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

//        male=new JRadioButton("Male");       //for radio buttons
//        male.setBounds(300,290,60,30);
//        male.setBackground(Color.white);
//        add(male);
//        female=new JRadioButton("Female");
//        female.setBounds(450,290,120,30);
//        female.setBackground(Color.white);
//        add(female);

//        ButtonGroup grp=new ButtonGroup();                    //With this we can select only one button
//        grp.add(male);
//        grp.add(female);

        JLabel email=new JLabel("Qualificaton:"  );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String EduCatogry[]={"Non-Graduate","Graduation","Post-Graduation","Doctorate","Others"};
         edu=new JComboBox(EduCatogry);
        edu.setBounds(300,315,400,30);
        edu.setBackground(Color.white);
        add(edu);

//        emailtext=new JTextField();
//        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
//        emailtext.setBounds(300,340,400,30);
//        add(emailtext);

        JLabel marital=new JLabel("Occupation"  );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String OccupCatogry[]={"Salaried","Self Employed","Student","Retired","Others"};
        Occupation=new JComboBox(OccupCatogry);
        Occupation.setBounds(300,390,400,30);
        Occupation.setBackground(Color.white);
        add(Occupation);

//        maried=new JRadioButton("Married");       //for radio buttons
//        maried.setBounds(300,390,100,30);
//        maried.setBackground(Color.white);
//        add(maried);
//        unmaried=new JRadioButton("Unmarried");
//        unmaried.setBounds(450,390,100,30);
//        unmaried.setBackground(Color.white);
//        add(unmaried);
//        other=new JRadioButton("Other");
//        other.setBounds(630,390,100,30);
//        other.setBackground(Color.white);
//        add(other);
//
//        ButtonGroup grp1=new ButtonGroup();                 //With this we can select only one button
//        grp1.add(maried);
//        grp1.add(unmaried);
//        grp1.add(other);

        JLabel address=new JLabel("Pan No:"  );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add( pan);

        JLabel city=new JLabel("Adhar No:"  );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        Adhar=new JTextField();
        Adhar.setFont(new Font("Raleway",Font.BOLD,14));
        Adhar.setBounds(300,490,400,30);
        add(Adhar);

        JLabel state=new JLabel("Senior Citizen:"  );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        scy=new JRadioButton("Yes");
        scy.setBounds(300,540,100,30);
        scy.setBackground(Color.white);
        add(scy);

        scn=new JRadioButton("No");
        scn.setBounds(450,540,100,30);
        scn.setBackground(Color.white);
        add( scn);

        ButtonGroup grp2=new ButtonGroup();                 //With this we can select only one button
        grp2.add(scy);
        grp2.add(scn);

//        statetext=new JTextField();
//        statetext.setFont(new Font("Raleway",Font.BOLD,14));
//        statetext.setBounds(300,540,400,30);
//        add(statetext);

        JLabel pin=new JLabel("Existing account :"  );
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);

        ey=new JRadioButton("Yes");
        ey.setBounds(300,590,100,30);
        ey.setBackground(Color.white);
        add(ey);

        en=new JRadioButton("No");
        en.setBounds(450,590,100,30);
        en.setBackground(Color.white);
        add(en);

        ButtonGroup grp1=new ButtonGroup();                 //With this we can select only one button
        grp1.add(scy);
        grp1.add(scn);

//        pintext=new JTextField();
//        pintext.setFont(new Font("Raleway",Font.BOLD,14));
//        pintext.setBounds(300,590,400,30);
//        add(pintext);

        JButton next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno= " " ;  //To convert long into String use " " +
        String sreligion=(String) religion.getSelectedItem(); //with the help of getText() function we can get value inside the nametext
        String sCatogry=(String) Category.getSelectedItem();
        String sincome =(String)income.getSelectedItem();
        String seducation=(String)edu.getSelectedItem();
        String sOccup=(String) Occupation.getSelectedItem();
        String seniorCiticen=null;
        if(scy.isSelected()){
            seniorCiticen="Yes";
        } else if (scn.isSelected()) {
            seniorCiticen="No";

        }

        //String email=emailtext.getText();
        String sExitingac=null;
        if(ey.isSelected()){
            sExitingac="Yes";
        } else if (en.isSelected()) {
            sExitingac="No";
        }

        String span=pan.getText();
        String sAdhar=Adhar.getText();
//        String state=statetext.getText();
//        String pin=pintext.getText();

        try{
                /*
                this is where we attachec the sql connectioon
                 */
                Conn cn=new Conn();
                // with the help of below querry we ARE storing our values in database.
                String q2 = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + sCatogry + "','" + sincome + "','" + seducation + "','" + sOccup + "','" + sAdhar + "','" + span + "','" + seniorCiticen + "','" + sExitingac + "')";

                cn.st.executeUpdate(q2);

                //Signup3
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);

        }


    }

    public static void main(String[] args) {

        new SignupTwo("");
    }


}



