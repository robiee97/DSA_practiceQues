import java.util.Scanner;
public class rotateANo{
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int rot = s.nextInt();
        s.close();
        int len=0;
        int temp= n;
        while(temp!=0){
            temp/=10;
            len++;
        }

        rot %= len;
        rot = rot < 0 ? rot + len : rot;

        int div=1;
        int mul=1;

        for(int i=1; i<=len; i++){
            if(i<=rot){
                mul *= 10;
            }else 
                div*=10;
        }
        int lastDigit=n/div;
        int firstDigit=n%div;

        int ans = firstDigit * mul + lastDigit;
        System.out.println(ans);
    }
}