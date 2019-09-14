import java.util.Arrays;

public class ArrayRec {

    public static void main(String args[]) {
        // int[] arr={10,20,30,40,50,60};
        // int[] arr = { 10, 20, 60, 30, 10, 40, 50, 50, 60, 80, 90 };
        // int vidx = 0;
        // int[] arr2={1,2,0,3};
        // disp1(arr,vidx);
        // disp2(arr,vidx);
        // dispTar(arr,60,vidx);
        // int ans=maxElement(arr, vidx);
        // System.out.println(ans);
        // int ans=minElement(arr, vidx);
        // System.out.println(ans);
        // int ans=lastIndex(arr,10,vidx);
        // System.out.println(ans);
        // inverseArr(arr2, vidx);
        // for(int i:arr2){
        // System.out.print(i+" ");
        // }
        // int[] arr2 =allIndex(arr, 60,vidx,0);
        // for(int i:arr2){
        // System.out.print(i+" ");
        // }
        // int[] arr1 = { 8, 9, 9, 9, 9, 9, 9 };
        // int[] arr2 = { 1 };
        // additionArr(arr1, arr2);
    }

    public static void disp1(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return;
        }
        disp(arr, vidx + 1);
        System.out.println(arr[vidx]);
    }

    public static void disp2(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return;
        }
        System.out.println(arr[vidx]);
        disp(arr, vidx + 1);
    }

    public static void dispTar(int[] arr, int tar, int vidx) {
        if (vidx == arr.length) {
            return;
        }
        if (arr[vidx] == tar) {
            System.out.println(vidx);
        }
        dispTar(arr, tar, vidx + 1);
    }

    public static int maxElement(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int ans = arr[vidx];
        int maxEINR = maxElement(arr, vidx + 1);
        ans = Math.max(maxEINR, ans);
        return ans;
    }

    public static int minElement(int[] arr, int vidx) {
        if (vidx == arr.length) {
            return Integer.MAX_VALUE;
        }

        int ans = arr[vidx];
        int minEINR = minElement(arr, vidx + 1);
        ans = Math.min(minEINR, ans);
        return ans;
    }

    public static int lastIndex(int[] arr, int data, int vidx) {
        if (vidx == arr.length) {
            return -1;
        }

        int ans = lastIndex(arr, data, vidx + 1);
        if (ans != -1)
            return ans;

        if (arr[vidx] == data) {
            return vidx;
        } else
            return -1;
    }

    public static void inverseArr(int[] arr, int vidx) {
        if (vidx == arr.length - 1) {
            return;
        }
        int data = arr[vidx];
        inverseArr(arr, vidx + 1);
        arr[data] = vidx;

    }

    public static int[] allIndex(int[] arr, int data, int vidx, int counter) {
        if (vidx == arr.length) {
            int[] base = new int[counter];
            return base;
        }

        if (arr[vidx] == data) {
            counter++;
        }
        int ans[] = allIndex(arr, data, vidx + 1, counter);
        if (arr[vidx] == data) {
            ans[counter - 1] = vidx;
        }
        return ans;
    }

    public static void additionArr(int[] arr1, int[] arr2) {

        int len = Math.max(arr1.length, arr2.length) + 1;
        int[] ans = new int[len];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = ans.length - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int val1 = arr1[i];
            int val2 = arr2[j];
            int statAns = val1 + val2 + carry;

            ans[k] = statAns % 10;
            carry = statAns / 10;

            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            int statAns = arr1[i] + carry;
            ans[k] = statAns % 10;
            carry = statAns / 10;
            i--;
            k--;
        }

        while (j >= 0) {
            int statAns = arr2[j] + carry;
            ans[k] = statAns % 10;
            carry = statAns / 10;
            j--;
            k--;
        }

        ans[k] = carry;

        if (ans[0] == 0) {
            for (int itr = 1; itr <= ans.length - 1; itr++) {
                System.out.print(ans[itr] + " ");
            }
        } else {
            for (int itr = 0; itr <= ans.length - 1; itr++) {
                System.out.print(ans[itr] + " ");
            }
        }
    }

}