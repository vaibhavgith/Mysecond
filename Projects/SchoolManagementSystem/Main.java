package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher t=new Teacher(1,"lissy",5000);
        Teacher t1=new Teacher(2,"malissa",5500);

        List<Teacher> tlist=new ArrayList<>();
        tlist.add(t);
        tlist.add(t1);

        Student s=new Student(11,"giga",9);
        Student s1=new Student(11,"gigrra",2);

        List<Student> v=new ArrayList<>();
        v.add(s);
        v.add(s1);

        School sl=new School(tlist,v);

        Teacher meg=new Teacher(6,"meg",6227);
        sl.addTeacher(meg);

        System.out.println(sl.getTotalMoneyEarned());

       s.payfees(2555);
        System.out.println(sl.getTotalMoneyEarned());


        System.out.println(s1);
        System.out.println(t);


    }
}
