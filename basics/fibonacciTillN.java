import java.util.Scanner;
public class fibonacciTillN{
    public static void main (String[] args){
        System.out.println("enter no");
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int a=0,b=1,c;
        int i=1;
        System.out.print(a+" ");
        System.out.print(b+" ");
        while(i<n){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
            // System.out.print(a+" ");
            i++;
        }
        s.close();
    }
}