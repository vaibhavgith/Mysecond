package StudentDatabaseApplication;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    private String courses;
    //private String courseName;
    private int  tutionbalance=0;


    /**
     * We use static keyword bcuz below value is not specific for one object instead it's available for
     * every object
     * When we know that one value is constant or we don't want to change it so we can make it as static
     */
    private static int costofCourse=600;
    private static int id=1001;

   /** //constructor :prompt user to enter students name and year
    // genrate an id;
    //Enroll in course;
    //view balance;
    //pay tution
    //show status
    */


  public  Student(){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter Students first name: ");
      this.firstName=sc.nextLine();

      System.out.println("Enter Students last name: ");
      this.lastName=sc.nextLine();

      System.out.println("1 - Freshmen\n2 -sophmore\n3 - junior\n4 - senior\n Enter student class level: ");

      this.gradeYear=sc.nextInt();
      System.out.println(firstName+" "+lastName+" "+gradeYear);

      setstudentId();
      System.out.println(firstName+" "+lastName+" "+gradeYear+" "+studentId);

    }
    private String setstudentId(){
      id++;
     return this.studentId=gradeYear+""+id;


    }

    //Enroll in course;
    public void enroll(){
      do {
          System.out.println("Enter course to enroll(Q to quit)");
          Scanner sc = new Scanner(System.in);
          String course = sc.nextLine();
          if (!course.equals("Q")) {
              courses = courses + "\n " + course;
              tutionbalance += costofCourse;
          }
          else{
              break;
          }
      }while (1!=0);
        System.out.println("Enrolled in: "+courses);
        System.out.println("Tution Balance: "+tutionbalance);

    }

    //view balace
    public void viewbalance()
    {
        System.out.println("Your balance is :"+tutionbalance);
    }

    //pay tution
    public void paytution()
    {
        viewbalance();
        System.out.println("Enter your payment: ");
          Scanner sc=new Scanner(System.in);
         int payment=sc.nextInt();
          tutionbalance-=payment;
          System.out.println("Thank you for payment "+payment);
          viewbalance();
    }

    //show status
    public String showInfo(){
      return "Name: "+firstName+" "+lastName+
              "\nCourses Enrolled: "+courses+
              "\nBalance: "+tutionbalance;

    }




}
