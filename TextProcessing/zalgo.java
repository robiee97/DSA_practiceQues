import java.util.*;

public class zalgo {

    public static void zalgoSolve(String text, String pattern) {
        String z = pattern + "$" + text;
        int[] za = zarr(z);

        for (int i = 1; i < za.length; i++) {
            if (za[i] == pattern.length()) {
                System.out.println("Pat found at : " + (i - pattern.length() - 1));
            }
        }
    }

    public static int[] zarr(String z) {
        int[] za = new int[z.length()];
        za[0] = 0;
        int i = 0;
        for (int x = 1; x < z.length(); x++) {
            int count = 0;
            int temp = x;
            while (temp < z.length() && z.charAt(i) == z.charAt(temp)) {
                count++;
                i++;
                temp++;
            }
            za[x] = count;
            i = 0;
        }
        return za;
    }

    public static void main(String[] args) {
        String s = "xabcabzabc";
        String pat = "abc";
        zalgoSolve(s, pat);
    }
}