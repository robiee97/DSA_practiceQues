
/* 
input 
display
allindex fun of type arraylist
rotate
reverse 
bs
bs low
bs up
bs closest
*/
import java.util.ArrayList;
import java.util.Scanner;

public class arrayProbExtend {
    public static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        solve();
    }

    public static void solve() {
        // System.out.println("enter the size of array");
        // int n=s.nextInt();
        // int[] arr= new int[n];
        // inputArr(arr);
        // displayArr(res);
        // System.out.println("enter data to be found");
        // int data=s.nextInt();
        // ArrayList<Integer> ans=allIndex(arr,data);
        // displayIN(ans);
        // int[]res=reverseArr(arr);
        // displayArr(res);
        // int[] rot=rotateArr(arr,3);
        // displayArr(rot);
        // System.out.println("enter the element to be searched");
        // int ele= s.nextInt();
        // int index = binarySearch(arr,ele);
        // System.out.println("element at "+index+" th index");

        // int indexBSLB= binarySearchLowerBound(arr,ele);
        // System.out.println("element at "+indexBSLB+" th index");

        // int indexBSUB= binarySearchUperBound(arr,ele);
        // System.out.println("element at "+indexBSUB+" th index");
        // int indexBSCE =closestBinarySearch(arr,ele);
        // System.out.println("element at "+indexBSCE+" th index");
    }

    public static void inputArr(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println("enter " + i + " th no.");
            arr[i] = s.nextInt();
        }
    }

    public static void displayArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> allIndex(int[] arr, int data) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void displayIN(ArrayList<Integer> ans) {
        for (Integer i : ans) {
            System.out.print("No. At " + i + " th Index");
        }
    }

    public static int[] reverseArr(int[] arr, int left, int right) {
        // int left=0;
        // int right=arr.length-1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static int[] rotateArr(int[] arr, int pivot) {
        reverseArr(arr, 0, pivot - 1);
        reverseArr(arr, pivot, arr.length - 1);
        reverseArr(arr, 0, arr.length - 1);
        return arr;
    }

    public static int binarySearch(int[] arr, int data) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] > data) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLowerBound(int[] arr, int data) {
        int lo = 0;
        ;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                if (mid - 1 >= 0 && arr[mid - 1] == data) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchUperBound(int[] arr, int data) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == data) {
                if (mid + 1 < arr.length && arr[mid + 1] == data) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int closestBinarySearch(int[] arr, int data) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] > data) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            if (lo >= arr.length)
                return hi;
            else if (hi < 0)
                return lo;
            else {
                return ((arr[lo] - data) < (data - arr[hi])) ? lo : hi;
            }
        }
        return -1;
    }
}