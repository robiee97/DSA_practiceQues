import java.util.*;

public class pnc {

    public static void main(String args[]) {
        // int[] arr = { 2, 3, 5 };
        // boolean[] mark = new boolean[arr.length];
        // permVar1(arr, 10, "");
        // combvar1(arr, 0, 10, "");
        // combvar2(arr, 0, mark, 10, "");
        // combvar3(arr, 0, 10, "");
        // permVar3(arr, mark, 10, "");
        // combvar4(arr, 0, 10, "");
        // permvar4(arr, 0, 10, "");
        // boolean[][] boxes = new boolean[4][4];
        // queenchange(boxes, 3, 0, "");
        // System.out.println(queenchange2(boxes,0, 3, 0, ""));
        // System.out.println(queenSeq(boxes, 0, 3, 0, ""));
        // System.out.println(queenSeq2(boxes, 0, 3, 0, ""));
        // System.out.println(NqueenPerm(boxes, 4, 0, ""));
        // System.out.println(NqueenComb(boxes, 0, 4, 0, ""));
        // NQUEEN(boxes, 0, 4, 0,"");
        // NKNIGHTS(boxes, 0, 3, 0, "");
        knightTour(new int[5][5], 1, 3, 1);
    }

    // **********coinchangeproblems******************************************

    // pervar1 (repeattion allowed)
    public static int permVar1(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans + " ");
            return 1;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += permVar1(arr, tar - arr[i], arr[i] + ans);
            }
        }
        return count;
    }

    // combvar1(repeatition allowed)
    public static int combvar1(int[] arr, int idx, int tar, String ans) {
        if (idx == arr.length || tar == 0) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combvar1(arr, i, tar - arr[i], ans + arr[i]);
            }
        }
        return count;
    }

    // pervar2(one coin only once)
    public static int permVar2(int[] arr, boolean[] mark, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans + " ");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0 && mark[i] == false) {
                mark[i] = true;
                count += permVar2(arr, mark, tar - arr[i], arr[i] + ans);
                mark[i] = false;
            }
        }
        return count;
    }

    // combvar2(one coin only once)
    public static int combvar2(int[] arr, int idx, boolean[] mark, int tar, String ans) {
        if (idx == arr.length || tar == 0) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0 && mark[i] == false) {
                mark[i] = true;
                count += combvar2(arr, i, mark, tar - arr[i], ans + arr[i]);
                mark[i] = false;
            }
        }
        return count;

    }

    // combvar3(another approach donot give another chance to itself)
    public static int combvar3(int[] arr, int idx, int tar, String ans) {
        if (idx == arr.length || tar == 0) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combvar3(arr, i + 1, tar - arr[i], ans + arr[i]);
            }
        }
        return count;
    }

    // pervar4(subsequence)
    public static int permvar4(int[] arr, int idx, int tar, String ans) {
        if (idx == arr.length || tar == 0) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += permvar4(arr, 0, tar - arr[idx], ans + arr[idx]);
            count += permvar4(arr, idx + 1, tar, ans);
        }
        return count;
    }

    // combvar4(subsequence)
    public static int combvar4(int[] arr, int idx, int tar, String ans) {
        if (idx == arr.length || tar == 0) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combvar4(arr, idx + 1, tar - arr[idx], ans + arr[idx]);
            count += combvar4(arr, idx + 1, tar, ans);
        }
        return count;
    }

    // ********************queenchngeprob*****************************************

    public static int queenchangePerm(boolean[] boxes, int tnq, int qsf, String ans) {
        if (qsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += queenchangePerm(boxes, tnq, qsf + 1, ans + " q " + qsf + " B " + i + 1);
                boxes[i] = false;
            }
        }
        return count;
    }

    public static int queenchangeComb(boolean[] boxes, int idx, int tnq, int qsf, String ans) {
        if (qsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += queenchangeComb(boxes, i + 1, tnq, qsf + 1, ans + " q " + qsf + 1 + " B " + i + 1);
                boxes[i] = false;
            }
        }
        return count;
    }

    public static int queenSeqComb(boolean[] boxes, int idx, int tnq, int qsf, String ans) {
        if (qsf == tnq || idx == boxes.length) {
            if (qsf == tnq) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!boxes[idx]) {
            boxes[idx] = true;
            count += queenSeqComb(boxes, idx + 1, tnq, qsf + 1, ans + " q " + qsf + 1 + " B " + idx + 1);
            boxes[idx] = false;
        }
        count += queenSeqComb(boxes, idx + 1, tnq, qsf, ans);

        return count;
    }

    public static int queenSeqPerm(boolean[] boxes, int idx, int tnq, int qsf, String ans) {
        if (qsf == tnq || idx == boxes.length) {
            if (qsf == tnq) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!boxes[idx]) {
            boxes[idx] = true;
            count += queenSeqPerm(boxes, 0, tnq, qsf + 1, ans + " q " + qsf + 1 + " B " + idx + 1);
            boxes[idx] = false;
            // count += queenSeqPerm(boxes,idx+1, tnq, qsf, ans ); new combination tarika
        }
        count += queenSeqPerm(boxes, idx + 1, tnq, qsf, ans);

        return count;
    }

    public static int NqueenPerm(boolean[][] boxes, int tnq, int qsf, String ans) {
        if (qsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < boxes.length * boxes[0].length; i++) {
            int r = i / boxes[0].length;
            int c = i % boxes[0].length;
            if (!boxes[r][c]) {
                boxes[r][c] = true;
                count += NqueenPerm(boxes, tnq, qsf + 1, ans + " q " + qsf + " B " + i);
                boxes[r][c] = false;
            }
        }
        return count;
    }

    // ****************************NQUEEN*************************************************

    public static boolean isValid(boolean[][] boxes, int r, int c) {
        if (r < 0 || c < 0 || r >= boxes.length || c >= boxes[0].length) {
            return false;
        }
        return true;
    }

    public static boolean isValidLocforQueen(boolean[][] boxes, int r, int c) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        for (int rad = 1; rad < boxes.length; rad++) {
            for (int d = 0; d < 8; d++) {
                int nr = r + rad * dir[d][0];
                int nc = c + rad * dir[d][1];
                if (isValid(boxes, nr, nc) && boxes[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int NQUEEN(boolean[][] boxes, int idx, int tnq, int qsf, String ans) {
        if (qsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < boxes.length * boxes[0].length; i++) {
            int r = i / boxes[0].length;
            int c = i % boxes[0].length;
            if (!boxes[r][c] && isValidLocforQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += NQUEEN(boxes, i + 1, tnq, qsf + 1, ans + " q " + qsf + " B " + i);
                boxes[r][c] = false;
            }
        }
        return count;
    }

    // *********************************NKNIGHTS******************************************

    public static boolean isSafeForKnight(boolean[][] boxes, int r, int c) {
        int[][] dir = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

        for (int d = 0; d < 8; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (isValid(boxes, nr, nc) && boxes[nr][nc]) {
                return false;
            }
        }
        return true;
    }

    public static int NKNIGHTS(boolean[][] boxes, int idx, int tnk, int ksf, String asf) {
        if (ksf == tnk) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < boxes.length * boxes[0].length; i++) {
            int r = i / boxes[0].length;
            int c = i % boxes[0].length;

            if (!boxes[r][c] && isSafeForKnight(boxes, r, c)) {
                boxes[r][c] = true;
                count += NKNIGHTS(boxes, i + 1, tnk, ksf + 1, asf + " K" + ksf + " B" + i);
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static int counter = 0;
    public static void knightTour(int[][] box, int r, int c, int mov) {
        if (r < 0 || c < 0 || r >= box.length || c >= box[0].length || box[r][c] != 0) {
            return;
        } else if (mov == box.length * box.length) {
            counter++;
            box[r][c] = mov;
            System.out.println("************" + counter + "*************");
            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[0].length; j++) {
                    System.out.print(box[i][j] + "\t");
                }
                System.out.println();
            }
            box[r][c] = 0;
            System.out.println("*************" + counter + "************");
            return;
        }
        box[r][c] = mov;
        knightTour(box, r - 2, c + 1, mov + 1);
        knightTour(box, r - 2, c - 1, mov + 1);
        knightTour(box, r - 1, c + 2, mov + 1);
        knightTour(box, r - 1, c - 2, mov + 1);
        knightTour(box, r + 2, c + 1, mov + 1);
        knightTour(box, r + 2, c - 1, mov + 1);
        knightTour(box, r + 1, c + 2, mov + 1);
        knightTour(box, r + 1, c - 2, mov + 1);
        box[r][c] = 0;
    }
}