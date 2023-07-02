package SchoolManagementSystem;

import java.security.PrivateKey;
import java.util.List;

/**
 * Many teachers and many students.
 * so we are going to use arraylist
 */
class School  {
private List<Teacher> teachers;
private List<Student> students;
private static int totalMoneyEarned;
private static int totalMoneySpent;


    /**
     * use alt + Insert button to genrate the constructor and get set etc.
     * @param teachers
     * @param student
     */
    public School(List<Teacher> teachers, List<Student> student) {
        this.teachers = teachers;
        this.students = student;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    /**
     * returns the lsit of teachers in school
     * @return
     */
    public List<Teacher> getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
       //
        // this.teacher = teacher;
       teachers.add(teacher);
    }

    public List<Student> getStudent() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public  int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static  void updateTotalMoneySpent(int MoneySpent) {
        totalMoneySpent -= MoneySpent;
    }


}
