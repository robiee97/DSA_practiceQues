import java.util.*;

public class talwar {
    public static void main(String args[]) {
        // ===================sudoku=====================================//
        // int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0,
        // 9, 0, 6, 0, 0 },{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2,
        // 0, 6, 3, 0, 0 } };
        // int[][] arr = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
        // 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
            // 0, 0, 0, 0, 0 }, };

            // ArrayList<int[]> zeroidx = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // if (arr[i][j] == 0) {
        // int[] a = { i, j };
        // zeroidx.add(a);
        // }
        // }
        // }
        // System.out.println(sudoku(arr, 0, c));
        // System.out.println(sudoku2(arr, zeroidx, 0));

        // // ==========================CRYPT============================//
        // crypt();
        // char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
        // { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
        // { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
        // { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
        // { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
        // { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' },
        // { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
        // { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
        // { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
        // { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

        // String[] words = { "agra", "norway", "england", "gwalior" };
        // System.out.println(crossword(box, words, 0));
        // magnets();
    }

    // ----------------------------SUDOKO--------------------------------

    public static int sudoku(int[][] arr, int idx, int remNum) {
        if (remNum == 0) {

            display(arr);
            return 1;

        }
        int counter = 0;

        int r = idx / arr[0].length;
        int c = idx % arr[0].length;

        if (arr[r][c] != 0) {
            counter += sudoku(arr, idx + 1, remNum);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValidToplace(arr, r, c, i)) {
                    arr[r][c] = i;
                    counter += sudoku(arr, idx + 1, remNum - 1);
                    arr[r][c] = 0;
                }
            }
        }
        return counter;
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValidToplace(int[][] arr, int r, int c, int num) {
        // moving vertically upside down
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] == num) {
                return false;
            }
        }

        // moving horizontally left right
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[r][i] == num) {
                return false;
            }
        }

        // is there similar num in square 3X3
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // ------------------------------(SUDOKU2-onlyOneOutput)-----------------------------

    public static int sudoku2(int[][] arr, ArrayList<int[]> zeroIdx, int idx) {
        if (idx == zeroIdx.size()) {
            display2(arr);
            return 1;

        }
        int counter = 0;

        int r = zeroIdx.get(idx)[0];
        int c = zeroIdx.get(idx)[1];

        for (int i = 1; i <= 9; i++) {
            if (isValidToplace2(arr, r, c, i)) {
                arr[r][c] = i;
                counter += sudoku2(arr, zeroIdx, idx + 1);

                if (counter == 1)
                    return counter;

                arr[r][c] = 0;
            }
        }

        return counter;
    }

    public static void display2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValidToplace2(int[][] arr, int r, int c, int num) {
        // moving vertically upside down
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] == num) {
                return false;
            }
        }

        // moving horizontally left right
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[r][i] == num) {
                return false;
            }
        }

        // is there similar num in square 3X3
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // ------------------------------CRYPT---------------------------------

    public static void crypt() {
        String a = "send";
        String b = "more";
        String c = "money";

        int[] freqMap = new int[26];

        for (int i = 0; i < c.length(); i++) {

            if (i < a.length()) {
                char ch = a.charAt(i);
                freqMap[ch - 'a']++;
            }
            if (i < b.length()) {
                char ch = b.charAt(i);
                freqMap[ch - 'a']++;
            }
            char ch = c.charAt(i);
            freqMap[ch - 'a']++;
        }

        String str = "";
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > 0) {
                str += (char) (i + 'a');
            }
        }
        boolean[] numMap = new boolean[10];
        cryptArth(str, a, b, c, numMap, freqMap);
    }

    public static int cryptArth(String str, String a, String b, String c, boolean[] numMap, int[] freqMap) {
        if (str.length() == 0) {
            if (isValidAns(a, b, c, freqMap)) {
                return 1;
            }
            return 0;
        }

        int counter = 0;
        char ch = str.charAt(0);
        for (int i = 0; i <= 9; i++) {

            if (!numMap[i]) {
                numMap[i] = true;
                freqMap[ch - 'a'] = i;

                counter += cryptArth(str.substring(1), a, b, c, numMap, freqMap);

                numMap[i] = false;
                freqMap[ch - 'a'] = 0;
            }
        }
        return counter;
    }

    public static boolean isValidAns(String a, String b, String c, int[] freqMap) {
        int num1 = getNum(a, freqMap);
        int num2 = getNum(b, freqMap);
        int num3 = getNum(c, freqMap);

        int st1 = freqMap[a.charAt(0) - 'a'];
        int st2 = freqMap[b.charAt(0) - 'a'];
        int st3 = freqMap[c.charAt(0) - 'a'];

        if (st1 != 0 && st2 != 0 && st3 != 0 && num1 + num2 == num3) {
            System.out.print(num1 + " " + num2 + " " + num3);
            return true;
        }
        return false;
    }

    public static int getNum(String str, int[] freqMap) {
        int num = 0;
        int pow = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            num += freqMap[str.charAt(i) - 'a'] * pow;
            pow *= 10;
        }
        return num;
    }

    // ===================================CROSSWORD=========================================//

    // 6 different checks using functions 3 of hor 3 of ver
    public static int crossword(char[][] box, String[] words, int idx) {
        if (idx == words.length) {
            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[0].length; j++) {
                    System.err.print(box[i][j] + "  ");
                }
                System.out.println();
            }
            return 1;
        }

        int count = 0;
        String word = words[idx];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == '-' || box[i][j] == word.charAt(0)) {
                    // hor
                    if (canPlaceHor(box, word, i, j)) {
                        boolean[] placedLocation = placeHor(box, word, i, j);
                        count += crossword(box, words, idx + 1);
                        UnplaceHor(box, placedLocation, i, j);
                    }
                    // ver
                    if (canPlaceVer(box, word, i, j)) {
                        boolean[] placedLocation = placeVer(box, word, i, j);
                        count += crossword(box, words, idx + 1);
                        UnplaceVer(box, placedLocation, i, j);
                    }
                }

            }
        }
        return count;
    }

    public static boolean canPlaceHor(char[][] box, String word, int r, int c) {
        if (c + word.length() > box[0].length) {
            return false;
        }
        if (c - 1 >= 0 && box[r][c - 1] != '+') {
            return false;
        }
        if (c + word.length() < box[0].length && box[r][c + word.length()] != '+') {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = box[r][c + i];
            if (ch != '-' && ch != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeHor(char[][] box, String word, int r, int c) {
        boolean[] placedLoction = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char ch = box[r][c + i];
            if (ch == '-') {
                box[r][c + i] = word.charAt(i);
                placedLoction[i] = true;
            }
        }
        return placedLoction;
    }

    public static void UnplaceHor(char[][] box, boolean[] placedLocation, int r, int c) {
        for (int i = 0; i < placedLocation.length; i++) {
            if (placedLocation[i]) {
                box[r][c + i] = '-';
                placedLocation[i] = false;
            }
        }
    }

    public static boolean canPlaceVer(char[][] box, String word, int r, int c) {
        if (r + word.length() > box.length) {
            return false;
        }
        if (r - 1 >= 0 && box[r - 1][c] != '+') {
            return false;
        }
        if (r + word.length() < box.length && box[r + word.length()][c] != '+') {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = box[r + i][c];
            if (ch != '-' && ch != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeVer(char[][] box, String word, int r, int c) {
        boolean[] placedLoction = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char ch = box[r + i][c];
            if (ch == '-') {
                box[r + i][c] = word.charAt(i);
                placedLoction[i] = true;
            }
        }
        return placedLoction;
    }

    public static void UnplaceVer(char[][] box, boolean[] placedLocation, int r, int c) {
        for (int i = 0; i < placedLocation.length; i++) {
            if (placedLocation[i]) {
                box[r + i][c] = '-';
                placedLocation[i] = false;
            }
        }
    }

    // ===========================Magnets(GFG)===================================================
    static int[] top = new int[] { 1, 0, 0, 2, 1, 0 };
    static int[] bottom = new int[] { 2, 0, 0, 2, 0, 3 };
    static int[] left = new int[] { 2, 3, 0, 0, 0 };
    static int[] right = new int[] { 0, 0, 0, 1, 0 };

    public static void magnets() {
        char[][] board = new char[][] { "hhhhvv".toCharArray(), "hhhhvv".toCharArray(), "vvvvhh".toCharArray(),
                "vvvvvv".toCharArray(), "hhhhvv".toCharArray() };
        solve(board, 0, 0);
    }

    public static boolean cph(char[][] board, int i, int j, String pat) {
        if (j - 1 >= 0 && board[i][j - 1] == pat.charAt(0)) {
            return false;
        } else if (i - 1 >= 0 && board[i - 1][j] == pat.charAt(0)) {
            return false;
        } else if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == pat.charAt(1)) {
            return false;
        } else if (j + 2 < board[0].length && board[i][j + 2] == pat.charAt(1)) {
            return false;
        }
        return true;
    }

    public static boolean cpv(char[][] board, int i, int j, String pat) {
        if (j - 1 >= 0 && board[i][j - 1] == pat.charAt(0)) {
            return false;
        } else if (i - 1 >= 0 && board[i - 1][j] == pat.charAt(0)) {
            return false;
        } else if (j + 1 < board[0].length && board[i][j + 1] == pat.charAt(0)) {
            return false;
        }
        return true;
    }

    public static void solve(char[][] board, int i, int j) {
        if (i == board.length && j == 0) {
            // horizontal
            for (int r = 0; r < board.length; r++) {
                int pcount = 0;
                int ncount = 0;
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] == '+') {
                        pcount++;
                    } else if (board[r][c] == '-') {
                        ncount++;
                    }
                }
                if (left[r] != pcount && left[r] != 0) {
                    return;
                } else if (right[r] != ncount && right[r] != 0) {
                    return;
                }
            }
            // vertical
            for (int c = 0; c < board[0].length; c++) {
                int pcount = 0;
                int ncount = 0;
                for (int r = 0; r < board.length; r++) {
                    if (board[r][c] == '+') {
                        pcount++;
                    } else if (board[r][c] == '-') {
                        ncount++;
                    }
                }
                if (top[c] != pcount && top[c] != 0) {
                    return;
                } else if (bottom[c] != ncount && bottom[c] != 0) {
                    return;
                }
            }

            // print maze
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
            return;

        } else if (j == board[0].length - 1) {
            if (board[i][j] == 'h') {
                // +-
                if (cph(board, i, j, "+-")) {
                    board[i][j] = '+';
                    board[i][j + 1] = '-';
                    solve(board, i + 1, 0);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }
                // -+
                if (cph(board, i, j, "-+")) {
                    board[i][j] = '-';
                    board[i][j + 1] = '+';
                    solve(board, i + 1, 0);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }
                // xx
                board[i][j] = 'X';
                board[i][j + 1] = 'X';
                solve(board, i + 1, 0);
                board[i][j] = 'h';
                board[i][j + 1] = 'h';
            } else if (board[i][j] == 'v') {
                // +-
                if (cpv(board, i, j, "+-")) {
                    board[i][j] = '+';
                    board[i + 1][j] = '-';
                    solve(board, i + 1, 0);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }
                // -+
                if (cpv(board, i, j, "-+")) {
                    board[i][j] = '-';
                    board[i + 1][j] = '+';
                    solve(board, i + 1, 0);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }
                // xx
                board[i][j] = 'X';
                board[i + 1][j] = 'X';
                solve(board, i + 1, 0);
                board[i][j] = 'v';
                board[i + 1][j] = 'v';
            } else {
                solve(board, i + 1, 0);
            }
        } else {
            if (board[i][j] == 'h') {
                // +-
                if (cph(board, i, j, "+-")) {
                    board[i][j] = '+';
                    board[i][j + 1] = '-';
                    solve(board, i, j + 1);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }
                // -+
                if (cph(board, i, j, "-+")) {
                    board[i][j] = '-';
                    board[i][j + 1] = '+';
                    solve(board, i, j + 1);
                    board[i][j] = 'h';
                    board[i][j + 1] = 'h';
                }
                // xx
                board[i][j] = 'X';
                board[i][j + 1] = 'X';
                solve(board, i, j + 1);
                board[i][j] = 'h';
                board[i][j + 1] = 'h';
            } else if (board[i][j] == 'v') {
                // +-
                if (cpv(board, i, j, "+-")) {
                    board[i][j] = '+';
                    board[i + 1][j] = '-';
                    solve(board, i, j + 1);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }
                // -+
                if (cpv(board, i, j, "-+")) {
                    board[i][j] = '-';
                    board[i + 1][j] = '+';
                    solve(board, i, j + 1);
                    board[i][j] = 'v';
                    board[i + 1][j] = 'v';
                }
                // xx
                board[i][j] = 'X';
                board[i + 1][j] = 'X';
                solve(board, i, j + 1);
                board[i][j] = 'v';
                board[i + 1][j] = 'v';
            } else {
                solve(board, i, j + 1);
            }
        }
    }

}