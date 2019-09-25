import java.util.*;

public class dp {
    public static void main(String[] args) {
        // int n=44;
        // int[] qb=new int[n+1];
        // long start=System.currentTimeMillis();
        // int fn=FibM(n, qb);
        // long end=System.currentTimeMillis();
        // System.out.println(fn+" in "+(end-start)+" ms ");

        // int n = 7;
        // int[] qb = new int[n + 1];
        // long start = System.currentTimeMillis();
        // int pn = climbdownstair(n, qb);
        // long end = System.currentTimeMillis();
        // System.out.println(pn + " in " + (end - start) + " ms ");

        // int[] arr = { 4, 2, 0, 0, 2, 4, 6, 3, 1, 0, 1, 2, 3, 1, 1 };
        // long start = System.currentTimeMillis();
        // // int res = countPaths(arr);
        // int res = minsteps(arr);
        // long end = System.currentTimeMillis();
        // System.out.println(res + " in " + (end - start) + " ms ");
        // int[][] arr = { { 2, 7, 3, 8, 0, 3, 7 }, { 4, 0, 1, 2, 4, 3, 4 }, { 3, 8, 5,
        // 9, 0, 8, 1 },
        // { 1, 6, 0, 4, 5, 5, 2 }, { 6, 2, 9, 5, 7, 0, 6 }, { 0, 8, 7, 9, 6, 3, 0 }, {
        // 1, 3, 5, 0, 5, 1, 0 } };

        int[][] arr = { { 1, 5, 1, 0, 3 }, { 1, 4, 0, 2, 3 }, { 4, 0, 1, 3, 2 }, { 2, 4, 0, 4, 1 },
                { 1, 2, 3, 2, 0 }, };
        // System.out.println(mcp(arr));
        System.out.println(glodmine(arr));
    }

    public static int FibM(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int fnm1 = FibM(n - 1, qb);
        int fnm2 = FibM(n - 2, qb);
        int fn = fnm1 + fnm2;
        qb[n] = fn;
        return fn;
    }

    public static int climbdownstair(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (qb[n] != 0) {
            return qb[n];
        }

        int pnm1 = climbdownstair(n - 1, qb);
        int pnm2 = climbdownstair(n - 2, qb);
        int pnm3 = climbdownstair(n - 3, qb);
        int pn = pnm1 + pnm2 + pnm3;

        qb[n] = pn;
        return pn;
    }

    public static int countPaths(int[] arr) {
        int[] strg = new int[arr.length];
        strg[strg.length - 1] = 1;
        for (int i = strg.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
                strg[i] += strg[j];
            }
        }
        return strg[0];
    }

    public static int minsteps(int[] arr) {
        int[] strg = new int[arr.length];
        strg[strg.length - 1] = 0;
        for (int i = strg.length - 2; i >= 0; i--) {
            int min = arr.length;
            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
                if (strg[j] < min) {
                    min = strg[j];
                }
            }
            strg[i] = min + 1;
        }
        return strg[0];
    }

    public static int mcp(int[][] local) {
        int[][] global = new int[local.length][local[0].length];

        for (int i = local.length - 1; i >= 0; i--) {
            for (int j = local[0].length - 1; j >= 0; j--) {
                if (i == local.length - 1 && j == local[0].length - 1) {
                    global[i][j] = local[i][j];
                } else if (i == local.length - 1) {
                    global[i][j] = local[i][j] + global[i][j + 1];
                } else if (j == local[0].length - 1) {
                    global[i][j] = local[i][j] + global[i + 1][j];
                } else {
                    global[i][j] = local[i][j] + Math.min(global[i][j + 1], global[i + 1][j]);
                }
            }
        }
        pmcp(global, 0, 0, "");
        return global[0][0];
    }

    public static void pmcp(int[][] g, int i, int j, String psf) {
        if (i == g.length - 1 && j == g[0].length - 1) {
            System.out.println(psf);
            return;
        } else if (i == g.length - 1) {
            pmcp(g, i, j + 1, psf + "h");
        } else if (j == g[0].length - 1) {
            pmcp(g, i + 1, j, psf + "v");
        } else {
            if (g[i][j + 1] < g[i + 1][j]) {
                pmcp(g, i, j + 1, psf + "h");
            } else if (g[i][j + 1] > g[i + 1][j]) {
                pmcp(g, i + 1, j, psf + "v");
            } else {
                pmcp(g, i, j + 1, psf + "h");
                pmcp(g, i + 1, j, psf + "v");
            }
        }
    }

    public static int glodmine(int[][] local) {
        int[][] global = new int[local.length][local[0].length];

        for (int j = local[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < local.length; i++) {
                if (j == local[0].length - 1) {
                    global[i][j] = local[i][j];
                } else if (i == 0) {
                    global[i][j] = local[i][j] + Math.max(global[i][j + 1], global[i + 1][j + 1]);
                } else if (i == local.length - 1) {
                    global[i][j] = local[i][j] + Math.max(global[i - 1][j + 1], global[i][j + 1]);
                } else {
                    int f1 = Math.max(global[i][j + 1], global[i + 1][j + 1]);
                    int f2 = Math.max(f1, global[i - 1][j + 1]);
                    global[i][j] = f2 + local[i][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < local.length; i++) {
            ans = Math.max(ans, global[i][0]);
        }
        return ans;
    }
}