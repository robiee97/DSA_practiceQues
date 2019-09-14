import java.util.*;

public class ArrayListRec {
    public static void main(String args[]) {
        // ArrayList<String> ans=Maze(0,0,2,2);
        // for(String s:ans){
        // System.out.print(s+" ");
        // }
        // System.out.println(ans.size());

        // ArrayList<String> ans1=MazeDiagnol(0,0,2,2);
        // for(String s:ans1){
        // System.out.print(s+" ");
        // }
        // System.out.println(ans1.size());

        // ArrayList<String> ans2=MultiMoveMaze(0,0,2,2);
        // for(String s:ans2){
        // System.out.print(s+" ");

        // }

        // System.out.println(ans2.size());
        // ArrayList<String> ans =RecArr(0, 10);
        // for(String s:ans){
        // System.out.print(s+" ");
        // }
        int num = 123;
        ArrayList<String> ans = keypad1(num);
        for (String s : ans) {
            System.out.print(s + " ");
        }

    }

    public static ArrayList<String> MazeDiagnol(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();

        if (sr + 1 <= er) {
            ArrayList<String> horizontal = MazeDiagnol(sr + 1, sc, er, ec);
            for (String smallAns : horizontal) {
                String realAns = "V" + smallAns;
                myAns.add(realAns);
            }
        }
        if (sc + 1 <= ec) {
            ArrayList<String> vertical = MazeDiagnol(sr, sc + 1, er, ec);
            for (String smallAns : vertical) {
                String realAns = "H" + smallAns;
                myAns.add(realAns);
            }
        }
        if (sc + 1 <= ec && sr + 1 <= er) {
            ArrayList<String> diagnol = MazeDiagnol(sr + 1, sc + 1, er, ec);
            for (String smallAns : diagnol) {
                String realAns = "D" + smallAns;
                myAns.add(realAns);
            }
        }
        return myAns;
    }

    public static ArrayList<String> Maze(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();
        if (sr + 1 <= er) {
            ArrayList<String> vertical = Maze(sr + 1, sc, er, ec);
            for (String smallAns : vertical) {
                String realAns = "V" + smallAns;
                myAns.add(realAns);
            }
        }
        if (sc + 1 <= ec) {
            ArrayList<String> horizontal = Maze(sr, sc + 1, er, ec);
            for (String smallAns : horizontal) {
                String realAns = "H" + smallAns;
                myAns.add(realAns);
            }
        }
        return myAns;
    }

    public static ArrayList<String> MultiMoveMaze(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();

        for (int i = 1; sr + i <= er; i++) {
            ArrayList<String> horizontal = MultiMoveMaze(sr + i, sc, er, ec);
            for (String smallAns : horizontal) {
                String realAns = "V" + i + smallAns;
                myAns.add(realAns);
            }
        }
        for (int i = 1; sc + i <= ec; i++) {
            ArrayList<String> vertical = MultiMoveMaze(sr, sc + i, er, ec);
            for (String smallAns : vertical) {
                String realAns = "H" + i + smallAns;
                myAns.add(realAns);
            }
        }
        for (int i = 1; sc + i <= ec && sr + i <= er; i++) {
            ArrayList<String> diagnol = MultiMoveMaze(sr + i, sc + i, er, ec);
            for (String smallAns : diagnol) {
                String realAns = "D" + i + smallAns;
                myAns.add(realAns);
            }
        }
        return myAns;
    }

    public static ArrayList<String> RecArr(int si, int ei) {
        if (si == ei) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myans = new ArrayList<>();
        for (int i = 1; i <= 6 && si + i <= ei; i++) {
            ArrayList<String> smallAns = RecArr(si + i, ei);
            for (String s : smallAns) {
                myans.add(i + s);
            }
        }
        return myans;
    }

    public static String getCode(int digit) {
        String[] val = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "uvw", "xyz", "*+#" };
        return val[digit];
    }

    public static ArrayList<String> keypad1(int num) {
        if (num == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int digit = num % 10;
        num = num / 10;

        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> smallAns = keypad1(num);
        String str = getCode(digit);
        for (int i = 0; i < str.length(); i++) {
            for (String s : smallAns) {
                myAns.add(s + str.charAt(i));
            }
        }
        return myAns;
    }

    public static ArrayList<String> subsequenceQ(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch = str.charAt(0);
        String nextstate = str.substring(1);
        ArrayList<String> myans = subsequenceQ(nextstate);
        for (String s : myans) {
            ans.add(s);
            ans.add(ch + s);
        }
        return ans;
    }

    

}
