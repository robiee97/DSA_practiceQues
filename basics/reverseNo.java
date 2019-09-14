import java.util.Scanner;
import java.lang.Math;
public class reverseNo{

    public static void main(String args[]) {
        System.out.println("Enter a no");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        reverseFunction(n);
        s.close();
    }

    public static void reverseFunction(int n){
        //counting digits
        int count=0;
        int a=n;
        while(a!=0){
            a=a/10;
            count++;
        }
        int power=count-1;
        int revNo=0;
        while(n!=0 && power>=0){
            int rem = n%10;
            revNo+= rem*Math.pow(10,power);
            n=n/10;
        power--;
        }
        System.out.println(revNo);
    }
}
