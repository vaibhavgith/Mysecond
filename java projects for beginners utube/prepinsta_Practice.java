import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class prepinsta_Practice {


    public static void main(String[] args) {
        int n1=98,n2=56;
        System.out.println(gethcf(n1,n2));
         


    }
    static int gethcf(int n1,int n2){

        if (n2==0)
            return n1;
        return gethcf(n2,n1%n2);

    }


}


