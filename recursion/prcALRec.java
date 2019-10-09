import java.util.*;

public class prcALRec {
    public static void main(String args[]) {
        // System.out.println(keyPad("179"));
        // System.out.println(ss("abc"));
        // ss2("abc","");
        // keyPad2("179", "");
    }

    static String[] arr = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> keyPad(String str) {

        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();

        char ch = str.charAt(0);
        String q = str.substring(1);

        ArrayList<String> smallAns = keyPad(q);
        String ele = arr[ch - '0'];

        for (int i = 0; i < ele.length(); i++) {
            for (String s : smallAns) {
                myAns.add(s + ele.charAt(i));
            }
        }
        return myAns;
    }

    public static ArrayList<String> ss(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();

        char ch = str.charAt(0);
        String q = str.substring(1);

        ArrayList<String> smallAns = ss(q);

        for (String s : smallAns) {
            myAns.add(s);
            myAns.add(ch + s);
        }
        return myAns;
    }

    public static void ss2(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String q = str.substring(1);

        ss2(q, ans);
        ss2(q, ans + ch);

    }

    public static void keyPad2(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String q = str.substring(1);

        String s = arr[ch - '0'];
        for (int i = 0; i < s.length(); i++) {
            keyPad2(q, ans + s.charAt(i));
        }

    }


}