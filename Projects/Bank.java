import java.sql.SQLOutput;
import java.util.*;
public class Bank {
    public static void main(String[] args) {
        BankAcc B=new BankAcc("vaibhav","B00123");
        B.showmenu();



    }
}
class BankAcc{
    int balance;
    int prvtranscation;
    String customerName;
    String customerId;

    BankAcc(String cname,String id){
        customerId=id;
        customerName=cname;

    }


    void deposit(int amount){
        if(amount!=0){
            balance+=amount;
            prvtranscation=amount;
        }
    }
    void withdraw(int amount ){
        if(amount!=0){
            balance-=amount;
            prvtranscation=-amount;
        }
    }
    void getPrvTransaction(){
        if(prvtranscation>0){
            System.out.println("Deposited: "+prvtranscation);
        } else if (prvtranscation<0) {
            System.out.println("withdraw: "+Math.abs(prvtranscation));
        }
        else{
            System.out.println("No transaction occured");
        }
    }

    void showmenu(){

        char option='\0';
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your ID"+customerId);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposite");
        System.out.println("C. Withdraw");
        System.out.println("D. previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=================================");
            System.out.println("Enter the option:");
            System.out.println("=================================");
            option=sc.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println(balance);
                    break;
                case 'B':
                    System.out.println("Enter the amount to be depoited");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("enetr amount to be withdraw");
                    int amount2 =sc.nextInt();
                     withdraw(amount2 );
                     break;
                case 'D':
                    getPrvTransaction();
                    break;
                case 'E':
                    System.out.println("*******");
                    break;
                default:
                    System.out.println("Invalid option!!");
                    break;

            }
        }while (option!='E');
        {
            System.out.println("Thanks for using our bank");

        }
    }
}
