import java.text.DecimalFormat;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your buying price for share");
        double buyingprice=sc.nextDouble();
        int day=1;
        double closingPrice=0.1;
        DecimalFormat df=new DecimalFormat("0.00");
        while(true){
            System.out.println("Enter your closing price for day "+day+" (any negative value to leave: ");
            closingPrice=sc.nextDouble();
            if (closingPrice<0.0) break;
            double earnings=closingPrice-buyingprice;
            if (earnings>0){
                System.out.println("After day "+day+" , you earned"+df.format(earnings)+"per share.");
            }
            else if (earnings<0.0){
                System.out.println("After day "+day+" , you lost "+df.format(-earnings)+"per share.");

            }
            else{
                System.out.println("after day"+day+",you have "+"no earnings per share.");
            }
            day+=1;
        }
    }
}
