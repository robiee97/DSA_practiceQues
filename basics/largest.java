import java.util.Scanner;

public class largest{
public static void main(String args[]){
Scanner s= new Scanner(System.in);

System.out.println("enter the three nos");
int a= s.nextInt();
int b= s.nextInt();
int c= s.nextInt();

if(a>b && a>c){
    System.out.println(a+" is the largest");
}

else if(b>a && b>c){
    System.out.println(b+" is the largest");
}

else{
    System.out.println(c+" is the largest");
}
s.close();
}
}
