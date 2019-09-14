import java.util.Scanner;
public class prime{
    public static void main(String args[]){
    boolean flag= false;
    System.out.println("enter a no.");
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag= true;
                break;
            }
        }
        if(flag==true){
            System.out.println("this is no is not prime");
        }else{
            System.out.println("this no is prime");
        }
        s.close();
    }
}