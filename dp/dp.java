import java.util.*;

public class dp {
    public static void main(String[] args) {
        // int n=44;
        // int[] qb=new int[n+1];
        // long start=System.currentTimeMillis();
        // int fn=FibM(n, qb);
        // long end=System.currentTimeMillis();
        // System.out.println(fn+" in "+(end-start)+" ms ");

        // int n = 7;
        // int[] qb = new int[n + 1];
        // long start = System.currentTimeMillis();
        // int pn = climbdownstair(n, qb);
        // long end = System.currentTimeMillis();
        // System.out.println(pn + " in " + (end - start) + " ms ");

        // int[] arr = { 4, 2, 0, 0, 2, 4, 6, 3, 1, 0, 1, 2, 3, 1, 1 };
        // long start = System.currentTimeMillis();
        // // int res = countPaths(arr);
        // int res = minsteps(arr);
        // long end = System.currentTimeMillis();
        // System.out.println(res + " in " + (end - start) + " ms ");

    }

    public static int FibM(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int fnm1 = FibM(n - 1, qb);
        int fnm2 = FibM(n - 2, qb);
        int fn = fnm1 + fnm2;
        qb[n] = fn;
        return fn;
    }

    public static int climbdownstair(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (qb[n] != 0) {
            return qb[n];
        }

        int pnm1 = climbdownstair(n - 1, qb);
        int pnm2 = climbdownstair(n - 2, qb);
        int pnm3 = climbdownstair(n - 3, qb);
        int pn = pnm1 + pnm2 + pnm3;

        qb[n] = pn;
        return pn;
    }

    public static int countPaths(int[] arr) {
        int[] strg = new int[arr.length];
        strg[strg.length - 1] = 1;
        for (int i = strg.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
                strg[i] += strg[j];
            }
        }
        return strg[0];
    }

    public static int minsteps(int[] arr) {
        int[] strg = new int[arr.length];
        strg[strg.length - 1] = 0;
        for (int i = strg.length - 2; i >= 0; i--) {
            int min = arr.length;
            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
                if (strg[j] < min) {
                    min = strg[j];
                }
            }
            strg[i] = min + 1;
        }
        return strg[0];
    }
}