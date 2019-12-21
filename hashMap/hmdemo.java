import java.util.*;

public class hmdemo {

    public static void main(String[] args) {
        // String str="ehfksdjbfiuwebfibdficuhwe";
        // hfc(str);
        // int[] arr1 = { 2, 1, 1, 3, 5, 1, 2 };
        // int[] arr2 = { 5, 2, 4, 1, 2, 2, 1 };
        // gce1(arr1, arr2);
        // gce2(arr1,arr2);
        // int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        // longestSeq(arr);
        // int[] arr = { 2, 3, -4, 1, 2, -3, 0, 1, 1, -5, 3, 0, 2, 1 };
        // System.out.println(allSubArr(arr, 3));
        // System.out.println(allSubArrInBinaryArr());
        // System.out.println(longestSubArr(arr, 4));
        // int[] arr = { 10, 8, 3, 4, 18, 9, 1, 7, -2, 4, 15, 3 };
        // System.out.println(allMulSubArr(arr, 5));
        // System.out.println(longestMulSubArr(arr, 5));
    }

    public static void hfc(String str) {
        HashMap<Character, Integer> fm = new HashMap<>();
        for (char key : str.toCharArray()) {
            if (fm.containsKey(key) == false) {
                fm.put(key, 1);
            } else {
                fm.put(key, fm.get(key) + 1);
            }
        }

        char mfc = str.charAt(0);
        for (char ch : fm.keySet()) {
            if (fm.get(ch) > fm.get(mfc)) {
                mfc = ch;
            }
        }
        System.out.println(mfc);
    }

    public static void gce1(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> fm1 = new HashMap<>();
        HashMap<Integer, Integer> fm2 = new HashMap<>();
        for (int key : arr1) {
            if (fm1.containsKey(key) == false) {
                fm1.put(key, 1);
            } else {
                fm1.put(key, fm1.get(key) + 1);
            }
        }
        for (int key : arr2) {
            if (fm2.containsKey(key) == false) {
                fm2.put(key, 1);
            } else {
                fm2.put(key, fm2.get(key) + 1);
            }
        }

        for (int val : fm1.keySet()) {
            if (fm2.containsKey(val)) {
                System.out.println(val);
            }
        }
    }

    public static void gce2(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> fm1 = new HashMap<>();
        for (int key : arr1) {
            if (fm1.containsKey(key) == false) {
                fm1.put(key, 1);
            } else {
                fm1.put(key, fm1.get(key) + 1);
            }
        }
        for (int val : arr2) {
            if (fm1.containsKey(val) && fm1.get(val) > 0) {
                System.out.println(val);
                fm1.put(val, fm1.get(val) - 1);
            }
        }
    }

    public static void longestSeq(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int val : arr) {
            map.put(val, true);
        }

        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        int bsp = 0;
        int blen = 0;

        for (int val : arr) {
            if (map.get(val) == true) {
                int tsp = val;
                int tlen = 1;

                while (map.containsKey(tsp + tlen) == true)
                    tlen++;

                if (tlen > blen) {
                    blen = tlen;
                    bsp = tsp;
                }
            }
        }
        for (int val = bsp; val < bsp + blen; val++) {
            System.out.println(val);
        }

    }

    public static int allSubArr(int[] arr, int tar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        int count = 0;

        map.put(psum, 1);

        for (int val : arr) {
            psum += val;
            if (map.containsKey(psum - tar)) {
                count += map.get(psum - tar);
            }
            if (map.containsKey(psum)) {
                map.put(psum, map.get(psum) + 1);
            } else {
                map.put(psum, 1);
            }
        }
        return count;
    }

    public static int allSubArrInBinaryArr() {
        int[] arr = { 1, 0, 0, 1, 0, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        return allSubArr(arr, 0);
    }

    public static int longestSubArr(int[] arr, int tar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        int idx = -1;
        int bl = 0;
        map.put(psum, idx);

        for (int i = 0; i < arr.length; i++) {
            psum += arr[i];
            int l = 0;
            if (map.containsKey(psum - tar)) {
                l = i - map.get(psum - tar);
                if (l > bl) {
                    bl = l;
                }
            }
            if (map.containsKey(psum) == false) {
                map.put(psum, i);
            }
        }
        return bl;
    }

    public static int allMulSubArr(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        int count = 0;

        map.put(psum, 1);

        for (int val : arr) {
            psum += val;
            int factor = psum % k;
            if (factor < 0) {
                factor += k;
            }
            if (map.containsKey(factor)) {
                count += map.get(factor);
                map.put(factor, map.get(factor) + 1);
            } else {
                map.put(factor, 1);
            }
        }
        return count;
    }

    public static int longestMulSubArr(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        int idx = -1;
        int bl = 0;
        map.put(psum, idx);

        for (int i = 0; i < arr.length; i++) {
            psum += arr[i];
            int l = 0;
            int factor = psum % k;
            if (factor < 0) {
                factor += k;
            }
            if (map.containsKey(factor)) {
                l = i - map.get(factor);
                if (l > bl) {
                    bl = l;
                }
            } else {
                map.put(factor, i);
            }
        }
        return bl;
    }

}