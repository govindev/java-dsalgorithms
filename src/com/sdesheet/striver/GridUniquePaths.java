package com.sdesheet.striver;

public class GridUniquePaths {
    public int uniquePaths(int m, int n) {
        // return getUniquePathsBruteForce(0,0,m-1,n-1);


        // int[][] dp = new int[m][n];
        // for (int[] row: dp) {
        //     Arrays.fill(row, -1);
        // }
        // return getUniquePathsDp(0, 0, m-1, n-1, dp);

        int N = m + n - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }


    public int getUniquePathsDp(int pm, int pn, int m, int n, int[][] dp) {
        if (dp[pm][pn] != -1) return dp[pm][pn];

        if (pm > m || pn > n) return 0;
        if (pm == m || pn == n) return 1;

        int rightPaths = (pn != n) ? getUniquePathsDp(pm, pn+1, m, n, dp) : 0;
        int downPaths = (pm != m) ? getUniquePathsDp(pm+1, pn, m, n, dp) : 0;

        dp[pm][pn] = rightPaths + downPaths;
        return dp[pm][pn];
    }

    public int getUniquePathsBruteForce(int pm, int pn, int m, int n) {
        if (pm > m || pn > n) return 0;
        if (pm == m || pn == n) return 1;
        int rightPaths = (pn != n) ? getUniquePathsBruteForce(pm, pn+1, m, n) : 0;
        int downPaths = (pm != m) ? getUniquePathsBruteForce(pm+1, pn, m, n) : 0;
        return rightPaths + downPaths;
    }
}