package StudentDatabaseApplication;

import java.util.Scanner;

public class studentdataseapp {
    public static void main(String[] args) {
        /**
         * how many new users we want to add
         * create n number of student
         */
        System.out.println("Enter no of students to enroll");
        Scanner sc=new Scanner(System.in);
        int numOfStudents=sc.nextInt();
        Student[] st=new Student[numOfStudents];

        for (int n=0;n<numOfStudents;n++){
            st[n]=new Student();
            st[n].enroll();
            st[n].paytution();
        }
        for (int n=0;n<numOfStudents;n++){
            System.out.println(st[n].showInfo());
        }


    }
}
