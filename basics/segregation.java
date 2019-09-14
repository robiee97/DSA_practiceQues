public class segregation {
    public static void main(String args[]) {
        int[] arr = { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        // zeroOneS(arr);
        // int[] arr = { 0, 1, 2, 1, 2, 2, 1, 1, 2, 0, 0, 1, 0 };
        // zeroOneTwoS(arr);
        int ans = votingAlgo(arr);
        boolean res = isvalid(arr, ans);

        if (res) {
            System.out.println("winner is " + ans);
        } else {
            System.out.println("-1");
        }
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
    }

    public static void zeroOneS(int[] arr) {
        int ptr = 0;
        int itr = 0;
        while (itr < arr.length) {
            if (arr[itr] == 1) {
                itr++;
            } else {
                swap(arr, ptr, itr);
                ptr++;
                itr++;
            }
        }
    }

    public static void zeroOneTwoS(int[] arr) {
        int ptr1 = 0;
        int itr = 0;
        int ptr2 = arr.length - 1;
        while (itr <= ptr2) {
            if (arr[itr] == 1) {
                itr++;
            } else if (arr[itr] == 0) {
                swap(arr, ptr1, itr);
                ptr1++;
                itr++;
            } else {
                swap(arr, ptr2, itr);
                ptr2--;
            }

        }

    }

    public static int votingAlgo(int[] arr) {
        int ele = arr[0];
        int freq = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ele) {
                freq++;
            } else
                freq--;
            if (freq == 0) {
                ele = arr[i];
                freq = 1;
            }
        }
        return ele;
    }

    public static boolean isvalid(int[] arr, int ele) {
        int freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ele == arr[i]) {
                freq++;
            }
        }
        return (freq > arr.length / 2) ? true : false;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}