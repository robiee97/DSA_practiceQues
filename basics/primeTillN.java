import java.util.*;

public class primeTillN {
    public static void main(String args[]) {
        System.out.println("enter the limit");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printPrime(n);
        s.close();
    }

    public static void printPrime(int n) {
        if (n <= 1) {
            System.out.println("this is not a prime");
        }
        for (int i = 2; i < n; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean checkPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            } else
                return true;
        }
        return false;
    }

}