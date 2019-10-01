import java.util.*;

public class test {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int q = scn.nextInt();
        // while(scn.hasNext()) {
        //     String s = scn.nextLine();
        //     System.out.println(lpsq(s));
        // }
        // scn.close();
            System.out.println(lpsq("abckycbc"));

    }

    public static int lpsq(String s) {
        int[][] strg = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0; i < s.length() - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = 1;
                } else if (g == 1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = 2 + strg[i + 1][j - 1];
                    } else {
                        strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
                    }
                }
            }
        }
        return strg[0][s.length() - 1];
    }
}