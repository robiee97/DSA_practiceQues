import java.util.Scanner;

public class noTillN{
    public static void main(String args[]){
        System.out.println("Enter the last no");
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<=n;i++){
            System.out.print(i+" ");
        }
        s.close();
    }
    
}