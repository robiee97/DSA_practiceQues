
public class voidTypeRec {
    public static void main(String args[]) {
        String str="123";
        ArrayList<String> s=subsequenceQ(str);
        for(String fin:s){
        System.out.println(fin);

        subsequence("123", "");
        keyPad2(123,"");
        System.out.println(counter);
        maze2(0, 0, 2, 2, "");
    }

    public static void subsequence(String que, String ans) {
        if (que.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = que.charAt(0);
        que = que.substring(1);
        subsequence(que, ans + ch);
        subsequence(que, ans);
    }

    public static void keyPad2(int num, String ans) {
        if (num == 0) {
            System.out.print(ans + " ");
            return;
        }
        int digit = num % 10;
        num = num / 10;

        String str = getCode(digit);
        for (int i = 0; i < str.length(); i++) {
            keyPad2(num, str.charAt(i) + ans);
            counter++;
        }
    }

    public static int maze2(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        if (sr <= er) {
            count+=maze2(sr + 1, sc, er, ec, ans + "V");
        }
        if (sc <= ec) {
            count+=maze2(sr, sc + 1, er, ec, ans + "H");
        }
        return count;
    }

    public static int encoding(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans);
            return 1;
        }

        char ch1 = str.charAt(0);
        String oneLength = str.substring(1);

        if (ch == '0') {
            oneLength = encoding(oneLength, ans);
        } else {
            char c1 = (char) ch - '1' + 'a';
            oneLength = encoding(oneLength, ans + c1);
        }
        if (ch == '1') {
            char ch2 = str.charAt(1);
            String twoLength = encoding(twoLength, ans + c2);
            int num = (ch1 - '0') * 10 + (ch2 - '0');
            char c2 = (char) ch2 - 1 + 'a';
        }
    }
}