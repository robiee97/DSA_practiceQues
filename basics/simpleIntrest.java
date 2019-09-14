import java.util.Scanner;

public class simpleIntrest{
public static void main(String args[]){
Scanner s= new Scanner(System.in);

System.out.println("Enter the principle value");
int p=s.nextInt();
System.out.println("Enter the Rate value");
int r=s.nextInt();
System.out.println("Enter the Time value");
int t=s.nextInt();

int si=(p*r*t)/100;
System.out.println("the simple intrest is :"+si);
s.close();
}
}