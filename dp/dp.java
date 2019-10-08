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
        // int[][] arr = { { 1, 5, 1, 0, 3 }, { 1, 4, 0, 2, 3 }, { 4, 0, 1, 3, 2 }, { 2,
        // 4, 0, 4, 1 },
        // { 1, 2, 3, 2, 0 }, };
        // System.out.println(mcp(arr));
        // System.out.println(glodmine(arr));

        // System.out.println(countBinary(5));
        // int[] arr = { 1, 2, 1, 3, 2, 6, 1, 2, 0, 1, 4 };
        // System.out.println(countEncoding(arr));
        // System.out.println(countSubseq("abcabc"));

        // int[] arr={3,2,5,1,8};
        // System.out.println(tss(arr, 9));

        // int[] coins = {2,3,5,6};
        // int amt = 7;
        // // System.out.println(coinChangePerm(coins, amt));
        // System.out.println(coinChangeComb(coins, amt));

        // int[] wts = { 2, 5, 1, 3, 4 };
        // int[] prices = { 15, 14, 10, 45, 30 };
        // int cap = 7;
        // System.out.println(zoknapsack(wts, prices, cap));
        // System.out.println(unboundedKS(wts, prices, cap));

        // System.out.println(friends(4));
        // System.out.println(tileProb(10, 2));

        // System.out.println(lcs("abcd", "aebd"));
        // System.out.println(lpsq("abckycbc"));
        // System.out.println(cpsq("abckycbc"));
        // clpss("abccbc");
        // System.out.println(cdivsq("235168", 6));

        // System.out.println(mcp("abccbc"));
        // System.out.println(eggdrop(2, 10));
        // System.out.println(mcm(new int[] { 10, 20, 30, 40, 50, 60 }));
        // System.out.println(greedyCoinPick(new int[] { 20, 30, 2, 2, 2, 10 }));
        // System.out.println(nthCatalan(5));
        // System.out.println(optimalBST(new int[] { 10, 20, 30, 40, 50, 60, 70 }, new
        // int[] { 2, 1, 4, 1, 1, 3, 5 }));
        // System.out.println(squareCut(30, 36, new int[31][37]));
        // lis(new int[] { 10, 21, 9, 33, 22, 50, 41, 60, 80, 7 });
        // System.out.println(rodcut(new int[] { 0, 3, 5, 6, 15, 10, 25, 12, 24 }));
        // System.out.println(maxSumNoAdjacentele(new int[] { 5, 6, 10, 100, 10, 5 }));

        // int[] starts = { 12, 2, 6, 7, 9, 1, 3 };
        // int[] ends = { 14, 5, 8, 10, 11, 5, 7 };
        // activitySelection(starts, ends);
        // int[] wts = { 10, 40, 20, 30 };
        // int[] prices = { 60, 40, 100, 120 };
        // System.out.println(fractionalKnapSack(wts, prices, 50));
        // int[] arrivals = { 900, 940, 950, 1100, 1500, 1800 };
        // int[] departures = { 910, 1200, 1120, 1130, 1900, 2000 };
        // System.out.println(minPlatforms(arrivals, departures));
        // String names = "abcdefghijklmno";
        // int[] dls = { 4, 2, 3, 2, 4, 5, 1, 1, 2, 3, 5, 2, 3, 5, 4 };
        // int[] prfs = { 37, 64, 98, 70, 80, 40, 54, 76, 42, 89, 27, 92, 38, 77, 46 };
        // System.out.println(jobSequence(names, dls, prfs));
        // int[][] mat=   {{1,0,0,1,0,0,1,0},
        //                 {1,1,1,1,1,1,1,1},
        //                 {1,1,0,1,1,1,1,1},
        //                 {1,0,1,1,1,1,1,0},
        //                 {0,1,1,1,1,1,1,1},
        //                 {1,0,1,0,1,1,0,1},
        //                 {1,0,0,1,1,1,1,1}};    
        // System.out.println(largestSquare(mat));
    
        ArrayList<Integer>[] pcmap = new ArrayList[]{
            new ArrayList<>(Arrays.asList(0, 2, 4)),
            new ArrayList<>(Arrays.asList(0, 1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(0, 4)),
        };
        int caps = 5;
        int[][] strg = new int[pcmap.length][1 << caps];
        System.out.println(countWaysToParty(pcmap, 0, 0, strg));
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

    public static int countBinary(int n) {
        int c0 = 1;
        int c1 = 1;

        for (int i = 2; i <= n; i++) {
            int nc0 = c1;
            int nc1 = c0 + c1;

            c0 = nc0;
            c1 = nc1;
        }
        return c0 + c1;
    }

    public static int countEncoding(int[] arr) {
        int[] strg = new int[arr.length];
        if (arr[0] == 0) {
            return 0;
        } else {
            strg[0] = 1;
            if (arr[1] != 0) {
                strg[1] = strg[0];
            }
            int num = arr[0] * 10 + arr[1];
            if (num >= 10 && num <= 26) {
                strg[1] += 1;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                strg[i] = strg[i - 1];
            }
            int num2 = arr[i - 1] * 10 + arr[i];
            if (num2 >= 10 && num2 <= 26) {
                strg[i] += strg[i - 2];
            }
        }
        return strg[arr.length - 1];
    }

    public static int countSubseq(String s) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                a = 1 + 2 * a;
            } else if (ch == 'b') {
                b = a + 2 * b;
            } else {
                c = b + 2 * c;
            }
        }
        return c;
    }

    public static boolean tss(int[] arr, int tar) {
        boolean[][] strg = new boolean[arr.length][tar + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg[0].length; j++) {
                if (i == 0 && j == 0) {
                    strg[i][j] = true;
                } else if (j == 0) {
                    strg[i][j] = true;
                } else if (i == 0) {
                    if (j == arr[0]) {
                        strg[i][j] = true;
                    }
                } else {
                    if (strg[i - 1][j] == true) {
                        strg[i][j] = true;
                    } else if (j >= arr[i]) {
                        if (strg[i - 1][j - arr[i]] == true) {
                            strg[i][j] = true;
                        }
                    }

                }
            }
        }
        ptss(strg, arr.length - 1, tar, arr, "");
        return strg[arr.length - 1][tar];
    }

    public static void ptss(boolean[][] strg, int i, int j, int[] arr, String asf) {
        if (i == 0) {
            if (j == 0) {
                System.out.println(asf);
            } else if (j == arr[0]) {
                System.out.println(asf + arr[0]);
            }
        } else {
            if (strg[i - 1][j] == true) {
                ptss(strg, i - 1, j, arr, asf);
            }
            if (j >= arr[i]) {
                if (strg[i - 1][j - arr[i]] == true) {
                    ptss(strg, i - 1, j - arr[i], arr, asf + arr[i] + " ");
                }
            }
        }
    }

    public static int coinChangePerm(int[] coins, int amt) {
        int[] strg = new int[amt + 1];
        strg[0] = 1;
        for (int i = 1; i <= amt; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    strg[i] += strg[i - coins[j]];
                }
            }
        }
        return strg[amt];
    }

    public static int coinChangeComb(int[] coins, int amt) {
        int[] strg = new int[amt + 1];
        strg[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amt; i++) {
                if (i >= coins[j]) {
                    strg[i] += strg[i - coins[j]];
                }
            }
        }
        return strg[amt];
    }

    public static int zoknapsack(int[] wts, int[] prices, int cap) {
        int[][] strg = new int[wts.length][cap + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 1; j < strg[0].length; j++) {
                if (i == 0) {
                    if (j >= wts[i]) {
                        strg[i][j] = prices[0];
                    }
                } else {
                    strg[i][j] = strg[i - 1][j];

                    if (j >= wts[i]) {
                        int factor = strg[i - 1][j - wts[i]] + prices[i];
                        if (factor > strg[i][j]) {
                            strg[i][j] = factor;
                        }
                    }
                }
            }
        }
        return strg[wts.length - 1][cap];
    }

    public static int unboundedKS(int[] wts, int[] prices, int cap) {
        int[] strg = new int[cap + 1];
        strg[0] = 0;

        for (int i = 1; i <= cap; i++) {
            int max = 0;
            for (int j = 0; j < wts.length; j++) {
                if (wts[j] <= i) {
                    max = Math.max(max, strg[i - wts[j]] + prices[j]);
                }
            }
            strg[i] = max;
        }
        return strg[cap];
    }

    public static int friends(int n) {
        int[] strg = new int[n + 1];
        strg[0] = strg[1] = 1;

        for (int i = 2; i < strg.length; i++) {
            strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
        }
        return strg[n];
    }

    public static int tileProb(int n, int m) {
        int[] strg = new int[n + 1];
        strg[0] = strg[1] = 1;
        for (int i = 2; i < strg.length; i++) {
            if (n <= 0) {
                strg[i] = 0;
            } else if (n < m) {
                strg[i] = 1;
            } else {
                strg[i] = strg[i - 1] + strg[i - m];
            }
        }
        return strg[n];
    }

    public static int lcs(String s1, String s2) {
        int[][] strg = new int[s1.length() + 1][s2.length() + 1];

        for (int i = strg.length - 2; i >= 0; i--) {
            for (int j = strg[0].length - 2; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    strg[i][j] = 1 + strg[i + 1][j + 1];
                } else {
                    strg[i][j] = Math.max(strg[i][j + 1], strg[i + 1][j]);
                }
            }
        }
        return strg[0][0];
    }

    public static int lpsq(String s) {
        int[][] strg = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0; i < s.length() - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = 1;
                } else if (g == 1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = 2 + strg[i + 1][j - 1];
                    } else {
                        strg[i][j] = Math.max(strg[i + 1][j], strg[i][j - 1]);
                    }
                }
            }
        }
        return strg[0][s.length() - 1];
    }

    public static int cpsq(String s) {
        int[][] strg = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0; i < s.length() - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = 1;
                } else if (g == 1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = strg[i + 1][j] + strg[i][j - 1] + 1;
                    } else {
                        strg[i][j] = strg[i + 1][j] + strg[i][j - 1] - strg[i + 1][j - 1];
                    }
                }
            }
        }
        return strg[0][s.length() - 1];
    }

    public static void clpss(String s) {
        boolean[][] strg = new boolean[s.length()][s.length()];

        int count = 0;
        int longest = 0;

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0; i < s.length() - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = true;
                } else if (g == 1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    strg[i][j] = s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1];
                }

                if (strg[i][j]) {
                    count++;
                    longest = g + 1;
                }
            }
        }
        System.out.println(count + " " + longest);
    }

    public static int cdivsq(String s, int d) {
        int[][] strg = new int[s.length()][d];

        strg[0][0] = 1;
        strg[0][(s.charAt(0) - 48) % d] += 1;

        for (int i = 0; i < strg.length - 1; i++) {
            for (int j = 0; j < d; j++) {
                strg[i + 1][j] += strg[i][j];
                strg[i + 1][(10 * j + s.charAt(i + 1) - 48) % d] += strg[i][j];
            }
        }
        return strg[s.length() - 1][0];
    }

    public static int mcp(String s) {
        int[][] strg = new int[s.length()][s.length()];

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0; i < s.length() - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = 0;
                } else if (g == 1) {
                    strg[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j) && strg[i + 1][j - 1] == 0) {
                        strg[i][j] = 0;
                    }

                    int min = s.length();
                    for (int k = 0; k < g; k++) {
                        int left = strg[i][i + k];
                        int right = strg[i + k + 1][j];

                        if (left + right < min) {
                            min = left + right;
                        }
                    }
                    strg[i][j] = min + 1;
                }
            }
        }
        return strg[0][s.length() - 1];
    }

    public static int eggdrop(int eggs, int floors) {
        int[][] strg = new int[eggs + 1][floors + 1];

        for (int e = 1; e <= eggs; e++) {
            for (int f = 0; f <= floors; f++) {
                if (e == 1 || f == 0 || f == 1) {
                    strg[e][f] = f;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k <= f; k++) {
                        int maeb = strg[e - 1][k - 1];
                        int maes = strg[e][f - k];
                        int maln = Math.max(maeb, maes);
                        min = Math.min(min, maln);
                    }
                    strg[e][f] = min + 1;
                }
            }
        }
        return strg[eggs][floors];
    }

    public static int mcm(int[] dims) {
        int[][] strg = new int[dims.length - 1][dims.length - 1];

        for (int g = 0; g < strg.length; g++) {
            for (int i = 0; i < strg.length - g; i++) {
                int j = i + g;

                if (g == 0) {
                    strg[i][j] = 0;
                } else if (g == 1) {
                    strg[i][j] = dims[i] * dims[j] * dims[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < g; k++) {
                        int left = strg[i][i + k];
                        int right = strg[i + 1 + k][j];
                        int multc = dims[i] * dims[j + 1] * dims[i + 1 + k];

                        int totalc = left + right + multc;
                        if (totalc < min) {
                            min = totalc;
                        }
                    }
                    strg[i][j] = min;
                }
            }
        }
        return strg[0][strg.length - 1];
    }

    // optimalStrategyOfGame
    public static int greedyCoinPick(int[] arr) {
        int[][] strg = new int[arr.length][arr.length];

        for (int g = 1; g < strg.length; g += 2) {
            for (int i = 0; i < strg.length - g; i++) {
                int j = i + g;
                if (g == 1) {
                    strg[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    int down = Math.min(strg[i + 1][j - 1], strg[i + 2][j]) + arr[i];
                    int left = Math.min(strg[i + 1][j - 1], strg[i][j - 2]) + arr[j];
                    strg[i][j] = Math.max(down, left);
                }
            }
        }
        return strg[0][strg.length - 1];
    }

    public static int nthCatalan(int n) {
        int[] strg = new int[n + 1];
        strg[0] = 1;
        strg[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                strg[i] += strg[j] * strg[i - 1 - j];
            }
        }
        return strg[n];
    }

    public static int optimalBST(int[] vals, int[] freq) {
        int[][] strg = new int[vals.length][vals.length];

        int[] fpsa = new int[freq.length];
        fpsa[0] = freq[0];
        for (int i = 1; i < fpsa.length; i++) {
            fpsa[i] = fpsa[i - 1] + freq[i];
        }

        for (int g = 0; g < strg.length; g++) {
            for (int i = 0; i < strg.length - g; i++) {
                int j = i + g;
                if (g == 0) {
                    strg[i][j] = freq[i];
                } else if (g == 1) {
                    strg[i][j] = Math.min(freq[i] + 2 * freq[j], 2 * freq[i] + freq[j]);
                } else {
                    int min = Integer.MAX_VALUE;

                    for (int k = 0; k <= g; k++) {
                        int left = k == 0 ? 0 : strg[i][i + k - 1];
                        int right = k == g ? 0 : strg[i + k + 1][j];

                        min = Math.min(left + right, min);
                    }
                    strg[i][j] = min + fpsa[j];
                    if (i > 0) {
                        strg[i][j] -= fpsa[i - 1];
                    }
                }
            }
        }
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg[0].length; j++) {
                System.out.print(strg[i][j] + "\t");
            }
            System.out.println();
        }

        return strg[0][vals.length - 1];
    }

    public static int squareCut(int h, int w, int[][] qb) {
        if (h == 0 || w == 0) {
            return 0;
        } else if (h == w) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if (qb[h][w] != 0) {
            return qb[h][w];
        }
        for (int x = 1; x <= Math.min(h, w); x++) {

            int lvxw = x;
            int lvxh = h - x;
            int rvxw = w - x;
            int rvxh = h;
            int lvfactor = squareCut(lvxh, lvxw, qb);
            int rvfactor = squareCut(rvxh, rvxw, qb);
            int vtotal = lvfactor + rvfactor;

            int lhxw = w - x;
            int lhxh = x;
            int rhxw = w;
            int rhxh = h - x;
            int lhfactor = squareCut(lhxh, lhxw, qb);
            int rhfactor = squareCut(rhxh, rhxw, qb);
            int htotal = lhfactor + rhfactor;

            res = Math.min(res, Math.min(vtotal, htotal));

        }
        res++;
        qb[h][w] = res;
        return res;
    }

    public static void lis(int[] arr) {
        int[] strg = new int[arr.length];
        strg[0] = 1;
        int res = 0;
        for (int i = 1; i < strg.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (strg[j] > max) {
                        max = strg[j];
                    }
                }
            }
            strg[i] = max + 1;
            if (strg[i] > res) {
                res = strg[i];
            }
        }
        System.out.println(res);
    }

    public static int rodcut(int[] arr) {
        int[] strg = new int[arr.length];

        strg[0] = 0;
        strg[1] = arr[1];

        for (int i = 2; i < strg.length; i++) {
            strg[i] = arr[i];
            int left = 1;
            int right = i - 1;
            while (left <= right) {
                if (strg[left] + strg[right] > strg[i]) {
                    strg[i] = strg[left] + strg[right];
                }
                left++;
                right--;
            }
        }
        return strg[strg.length - 1];
    }

    public static int maxSumNoAdjacentele(int[] arr) {
        int inc = arr[0];
        int exc = 0;

        for (int i = 1; i < arr.length; i++) {
            int ni = exc + arr[i];
            int ne = Math.max(inc, exc);

            inc = ni;
            exc = ne;
        }
        return Math.max(inc, exc);
    }

    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            return this.end - other.end;
        }
    }

    public static void activitySelection(int[] starts, int[] ends) {
        Interval[] intvs = new Interval[starts.length];

        for (int i = 0; i < starts.length; i++) {
            intvs[i] = new Interval(starts[i], ends[i]);
        }

        Arrays.sort(intvs);
        int count = 1;
        int lastAct = 0;

        for (int i = 1; i < intvs.length; i++) {
            if (intvs[i].start > intvs[lastAct].end) {
                count++;
                lastAct = i;
            }
        }
        System.out.println(count);
    }

    public static class Product implements Comparable<Product> {
        int wt;
        int price;
        double pwratio;

        public Product(int wt, int price) {
            this.wt = wt;
            this.price = price;
            this.pwratio = price * 1.0 / wt;
        }

        public int compareTo(Product other) {
            if (this.pwratio > other.pwratio) {
                return +1;
            } else if (this.pwratio < other.pwratio) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static double fractionalKnapSack(int[] wts, int[] prices, int cap) {
        Product[] prds = new Product[wts.length];
        for (int i = 0; i < prds.length; i++) {
            prds[i] = new Product(wts[i], prices[i]);
        }

        Arrays.sort(prds);
        double vib = 0;
        int rc = cap;
        int i = prds.length - 1;
        while (rc > 0) {
            if (prds[i].wt < rc) {
                vib += prds[i].price;
                rc -= prds[i].wt;
            } else {
                vib += rc * prds[i].pwratio;
                rc = 0;
            }
            i--;
        }
        return vib;
    }

    public static int minPlatforms(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int i = 0;
        int j = 0;
        int count = 0;
        int omax = 0;
        while (i < arrivals.length) {
            if (arrivals[i] <= departures[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            omax = Math.max(omax, count);
        }
        return omax;
    }

    public static class Jobs implements Comparable<Jobs> {
        char name;
        int deadline;
        int profit;

        public Jobs(char name, int deadline, int profit) {
            this.name = name;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int compareTo(Jobs other) {
            return this.profit - other.profit;
        }
    }

    public static int jobSequence(String names, int[] deadlines, int[] profits) {
        Jobs[] jobs = new Jobs[names.length()];
        int max = 0;
        for (int i = 0; i < names.length(); i++) {
            jobs[i] = new Jobs(names.charAt(i), deadlines[i], profits[i]);
            max = Math.max(max, deadlines[i]);
        }
        char[] res = new char[max + 1];
        Arrays.sort(jobs);

        int profit = 0;
        for (int i = jobs.length - 1; i >= 0; i--) {
            int spot = jobs[i].deadline;
            while (spot > 0) {
                if (res[spot] == '\0') {
                    res[spot] = jobs[i].name;
                    profit += jobs[i].profit;
                    break;
                } else {
                    spot--;
                }
            }
        }
        for (char i : res) {
            System.out.print(i + " ");
        }
        return profit;
    }

    public static int largestSquare(int[][] mat) {
        int[][] strg = new int[mat.length][mat[0].length];
        int omax = 0;
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (i == mat.length - 1 && j == mat[0].length - 1) {
                    strg[i][j] = mat[i][j];
                } else if (i == mat.length - 1) {
                    strg[i][j] = mat[i][j];
                } else if (j == mat[0].length -1) {
                    strg[i][j] = mat[i][j];
                } else {
                    if (mat[i][j] == 0) {
                        strg[i][j] = 0;
                    } else {
                        strg[i][j] = 1 + Math.min(strg[i][j + 1], Math.min(strg[i + 1][j], strg[i + 1][j + 1]));
                    }
                }
                if (strg[i][j] > omax) {
                    omax = strg[i][j];
                }
            }
        }
        return omax;
    }
    
    //dp with bitmasking
    public static int counter = 0;
    public static int countWaysToParty(ArrayList<Integer>[] pcmap, int pidx, int mask, int[][] strg){
        if(pidx == pcmap.length){
            return 1;
        }

        if(strg[pidx][mask] != 0){
            return strg[pidx][mask];
        }
        int count = 0;
        System.out.println(++counter + ". " + pidx + " " + mask);
        for(int cap: pcmap[pidx]){
            if((mask & (1 << cap)) == 0){
                mask = mask ^ (1 << cap);
                
                int cc = countWaysToParty(pcmap, pidx + 1, mask, strg);
                count += cc;

                mask = mask ^ (1 << cap);
            }
        }
        strg[pidx][mask] = count;
        return count;
    }
}