package SchoolManagementSystem;

public class Teacher {
    private int id;
   private String Tname;
   private int salary;

   private int salaryearned;


    Teacher(int id,String Tname,int salary){
        this.id=id;
        this.Tname=Tname;
        this.salary=salary;
        this.salaryearned=0;
    }
    public String getTname(){
        return Tname;
    }
    public int getId(){
        return id;
    }
    public int getSalary(){
        return salary;
    }

    /**
     * we use setter here bcuz we knw that we only going to change the salary we dont want to change the id
     * and name
     * @param salary
     */
    public void setSalary(int salary){
        this.salary=salary;
    }

    public void recivedsalary(int salary){
        salaryearned+=salary;
        School.updateTotalMoneyEarned(salary);
    }

    @Override
    public String toString() {
        return "Name of the teacher:  "+Tname+
                "total salar earnec: "+salaryearned;
    }
}
