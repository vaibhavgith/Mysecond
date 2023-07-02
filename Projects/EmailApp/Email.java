package EmailApp;

import java.util.Scanner;

class Email {
   private   String firstname;
   private String lastname;
   private   String password;
   private String department;
   private int mailboxcapacity=500;
   private  String email;
   private int passlength=8;
   private   String alternateemail;
   private String companySuffix="abccompany.com";
    private String changepassword;

    //constructor to reciev the firstname and lastname
    Email(String firstname,String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
     System.out.println("done "+this.firstname+this.lastname);

     this.department=setDepartment();
        System.out.println("Department: "+this.department);

        this.password=randomPass(passlength);
        System.out.println("Your password is "+this.password);

        email=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+companySuffix;
        System.out.println("yours mail id is :"+email);

    }
     //ask for the department
 private String setDepartment(){
  System.out.println("Enter the department \n1 sales\n2 Development \n3 Accounting \n0 none \n Enter the department code: ");
     Scanner sc=new Scanner(System.in);
     int depchoice=sc.nextInt();
     if(depchoice==1){
         return "sales";
     } else if (depchoice==2) {
         return "Development";
     } else if (depchoice==3) {
         return "Accounting";
     }
     else{
         return "none";
     }
 }
     // Genrate a random password
    private String randomPass(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#&$";
        char []password=new char[length];
        for (int i=0;i<length;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailboxcapacity(int capacity){
        this.mailboxcapacity=capacity;
    }
     //set the alternate email
    public void setAlternateemail(String altemail){
        this.alternateemail=altemail;
    }
    //change the password
    public void changepassword(String password){
        this.changepassword=password;
    }

    public int getMailboxcapacity(){
        return mailboxcapacity;
    }
    public String getalternateemail(){return alternateemail;}
    public String getPassword(){return password;}

    public String show(){
        return "Display name: "+firstname+" "+lastname+
                "company email: "+email+
                "mailboxcapacity: "+mailboxcapacity+"mb"+
                "alternate email"+ getalternateemail()+
                "password "+getPassword()
                ;
    }







 }
