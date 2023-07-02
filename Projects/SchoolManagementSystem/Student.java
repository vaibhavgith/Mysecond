package SchoolManagementSystem;

//this class is responsible for students details

public class Student {
    private int id;
    private String name;
    private int grade;

    private int feesPaid;
   private int totalFess;



    /**
     *  //role of constructor initialise the object

     */

    Student(int id,String name,int grade){
        feesPaid=0;
        this.id=id;
        this.name=name;
       this.grade=grade;
    }

    /**
     * Not going to alter students name and his id so we dont need set methond
     */
    public void setGrade(int grade){
        this.grade=grade;
    }

    /**
     * add fees to feespaid
     * @param fees
     */
    public void payfees(int fees){
        feesPaid+=fees;
        School.updateTotalMoneyEarned(feesPaid);

    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public int getFeesPaid(){
        return feesPaid;
    }
    public int getTotalFess(){
        return totalFess;
    }

   public int getReamaingFees(){
        return totalFess-feesPaid;
   }

    @Override
    public String toString() {
        return "Students name:"+name+
                "total feespaid"+feesPaid;
    }
}
