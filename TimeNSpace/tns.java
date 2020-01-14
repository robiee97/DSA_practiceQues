import java.util.*;

public class tns {
    public static void main(String[] args) {
        // poly(2, 3);
        // prime(30);
        // fact(spf(10000), 360);
        // fact(spf(10000), 144);
        // fact(spf(10000), 50);
        // fact(spf(10000), 98);

        // setABit(57, 2);
        // unsetABit(57, 4);
        // toggleABit(57, 3);
        // System.out.println(printBits(57));
        // bs("101");
        // int[] arr = { 0, 1, 2, 0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
        // int[] arr = { 0, 150, 48, 78, 0, 99, 1, 0, 1, 0, 1, 0, 23, 1, 0, 1, 0, 0 };
        // int[] arr = { 20, 50, 10, 80, 60, 30, 70, 40 };
        // segZeroOne(arr);
        // System.out.println();
        // segZeroOneTwo(arr);

        // hilo(arr, 20,50);

        // int[] arr = { 2, 5, 1, 8, 6, 3, 7, 4 };
        // int[] sarr = mergerSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(sarr));
        // System.out.println(invC);

        // System.out.println(quickSelect(arr, 0, arr.length - 1, 2));
        // quickSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));

        // int[] arr={2,1,3,1,2,4,1,2,4,7,9,8,3,4,8,7,3,2,8,7};
        // int[] sa=countSort(arr);
        // System.out.println(Arrays.toString(sa));

        // int[] arr={392,74,9,35324,856,43,87,5,234,8756,82,3,6,4,823,9,4,7,902,3,7,19};
        // int[] sa=radixSort(arr);
        // System.out.println(Arrays.toString(sa));
        // String str="shdfjkdfhisahifuewhiadsfnkjf";
        // highFChar(str);

        // int[] arr = {33,21,82,50,70,36,20,26,54};
        // int[] arr = {10,20,100,54,130};
        // makePallinOfArr(arr);
    }

    public static int invC = 0;

    public static int[] mergerSort2(int[] one, int[] two) {
        int[] res = new int[one.length + two.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                res[k++] = one[i++];
            } else {
                res[k++] = two[j++];
                invC += one.length - i;
            }
        }
        while (i < one.length) {
            res[k++] = one[i++];
        }
        while (j < two.length) {
            res[k++] = two[j++];
        }
        return res;
    }

    public static int[] mergerSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;

        int[] fh = mergerSort(arr, lo, mid);
        int[] sh = mergerSort(arr, mid + 1, hi);
        int[] fa = mergerSort2(fh, sh);

        return fa;
    }

    public static void poly(int x, int n) {
        int co = n;
        int px = x;
        int sum = 0;

        while (co >= 1) {
            sum += co * px;
            px = px * x;
            co--;
        }
        System.out.println(sum);
    }

    public static void prime(int n) {
        boolean[] ar = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            for (int j = i; i * j < n; j++) {
                if (!ar[i * j]) {
                    ar[i * j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!ar[i]) {
                System.out.println(i);
            }
        }
    }

    public static int[] spf(int n) {
        int[] res = new int[n + 1];
        boolean[] ar = new boolean[n + 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (!ar[i]) {
                for (int j = i; i * j < n; j++) {
                    if (!ar[i * j]) {
                        ar[i * j] = true;
                        res[i * j] = i;
                    }
                }
            }
        }
        return res;
    }

    public static void fact(int[] spf, int x) {
        System.out.println(x + " = ");
        while (x > 1) {
            System.out.print(spf[x] + "*");
            x = x / spf[x];
        }
        System.out.println();
    }

    public static void setABit(int x, int k) {
        int a = 1 << k;
        x = a | x;
        System.out.println(x);
    }

    public static void unsetABit(int x, int k) {
        int a = ~(1 << k);
        x = a & x;
        System.out.println(x);
    }

    public static void toggleABit(int x, int k) {
        int a = 1 << k;
        x = a ^ x;
        System.out.println(x);
    }

    public static String printBits(int x) {
        String str = "";
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((x & mask) == 0) {
                str += "0";
            } else {
                str += "1";
            }
        }
        return str;
    }

    public static void bs(String x) {
        int bno = Integer.parseInt(x, 2);
        System.out.println(bno);
    }

    public static void segZeroOne(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void segZeroOneTwo(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i < k) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void hilo(int[] arr, int l, int h) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i < k) {
            if (arr[i] >= l && arr[i] < h) {
                i++;
            } else if (arr[i] < l) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static int part(int[] arr, int lo, int hi) {
        int pivot = arr[hi];

        int i = 0;
        int j = 0;

        while (i <= hi) {
            if (arr[i] > pivot) {
                i++;
            } else if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pidx = part(arr, lo, hi);
        if (k < pidx) {
            return quickSelect(arr, lo, pidx - 1, k);
        } else if (k > pidx) {
            return quickSelect(arr, pidx + 1, hi, k);
        } else {
            return arr[pidx];
        }
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pidx = part(arr, lo, hi);
        quickSort(arr, lo, pidx - 1);
        quickSort(arr, pidx + 1, hi);
    }

    public static int[] countSort(int[] input) {
        int n = input.length;
        int r = 10;
        int[] fm = new int[r];

        for (int val : input) {
            fm[val]++;
        }
        for (int i = 1; i < fm.length; i++) {
            fm[i] += fm[i - 1];
        }
        int[] output = new int[n];
        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i];
            fm[val]--;
            output[fm[val]] = val;
        }
        return output;
    }

    public static int[] countSortForRS(int[] input, int div) {
        int n = input.length;
        int r = 10;
        int[] fm = new int[r];

        for (int val : input) {
            val = val / div % 10;
            fm[val]++;
        }
        for (int i = 1; i < fm.length; i++) {
            fm[i] += fm[i - 1];
        }
        int[] output = new int[n];
        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i];
            val = val / div % 10;
            fm[val]--;
            output[fm[val]] = input[i];
        }

        return output;
    }

    public static int[] radixSort(int[] input) {
        int max = 0;
        for (int val : input) {
            max = Math.max(max, val);
        }
        int div = 1;
        while (max / div > 0) {
            input = countSortForRS(input, div);
            div = div * 10;
        }
        return input;
    }

    public static void highFChar(String str) {

        int[] fm = new int[26];
        int max = 0;
        for (char val : str.toCharArray()) {
            fm[val - 'a']++;
            if (fm[val - 'a'] > fm[max]) {
                max = val - 'a';
            }
        }
        System.out.println((char) (max + 'a'));

    }

    public static void makePallinOfArr(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] < arr[j]) {
                int temp = arr[i];
                arr[i + 1] = arr[i + 1] + temp;
                i++;
            } else if (arr[i] > arr[j]) {
                int temp = arr[j];
                arr[j - 1] = arr[j - 1] + temp;
                j--;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int itr : arr) {
            if (map.containsKey(itr)) {
                map.put(itr, map.get(itr) + 1);
            } else
                map.put(itr, 1);
        }
        map.put(arr[i - 1], 2);

        for (int sol : arr) {
            if (map.get(sol) == 2) {
                System.out.print(sol + " ");
            }
        }
    }
}