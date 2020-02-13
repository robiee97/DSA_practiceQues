import java.util.*;

public class rabinKarp {
    public static void main(String[] args) {
        String text = "cbksfvkgyaukggdfwekugfcbnxmqcniuwe";
        String pat = "kggdfwe";
        rabinKarpSolve(text, pat);
    }

    public static void rabinKarpSolve(String text, String pat) {
        int i = 0;
        int j = i + pat.length();
        int patHF = hashFn(pat);
        while (j < text.length()) {
            String block = text.substring(i, j);
            if (patHF == hashFn(block)) {
                if (checkStrings(pat, block)) {
                    System.out.println("pattern found @ " + i);
                }
            }
            i++;
            j++;
        }
    }

    public static int hashFn(String str) {
        int hashValue = 0;
        str=str.toLowerCase();
        for (int i = str.length() - 1, j = 0; i >= 0 && j < str.length(); i--, j++) {
            hashValue += ((int) (str.charAt(j) - 'a')) * Math.pow(10, i);
        }
        hashValue%=Math.pow(2,31);   // if can't fit in int memory
        return hashValue;
    }

    public static boolean checkStrings(String pat, String block) {
        for (int i = 0; i < pat.length(); i++) {
            if (pat.charAt(i) != block.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}