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
        boolean[][] boxes = new boolean[3][3];
        // queenchange(boxes, 3, 0, "");
        // System.out.println(queenchange2(boxes,0, 3, 0, ""));
        // System.out.println(queenSeq(boxes, 0, 3, 0, ""));
        // System.out.println(queenSeq2(boxes, 0, 3, 0, ""));
        // System.out.println(NqueenPerm(boxes, 4, 0, ""));
        System.out.println(NqueenComb(boxes, 0, 4, 0, ""));

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
    // pervar3(no repeatition)

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

    public static int NqueenComb(boolean[][] boxes, int idx, int tnq, int qsf, String ans) {
        if (qsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < boxes.length * boxes[0].length; i++) {
            int r = i / boxes[0].length;
            int c = i % boxes[0].length;
            if (!boxes[r][c] && isValid(boxes, r, c, idx)) {
                boxes[r][c] = true;
                count += NqueenComb(boxes, i + 1, tnq, qsf + 1, ans + " q " + qsf + " B " + i);
                boxes[r][c] = false;
            }
        }
        return count;
    }

   
}