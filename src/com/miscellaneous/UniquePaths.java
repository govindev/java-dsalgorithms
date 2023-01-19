package com.miscellaneous;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
//         return getUniquePathsBruteForce(0, 0, m-1, n-1);

//         int[][] dp = new int[m][n];

//         for (int[] dpArr : dp) {
//             Arrays.fill(dpArr, -1);
//         }

//         return getUniquePathsDp(0, 0, m-1, n-1, dp);

        int N = m + n -2;
        int r = m-1;
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

        int rightPaths = getUniquePathsDp(pm, pn+1, m, n, dp);
        int downPaths = getUniquePathsDp(pm+1, pn, m, n, dp);

        dp[pm][pn] = rightPaths + downPaths;
        return dp[pm][pn];
    }

    public int getUniquePathsBruteForce(int pm, int pn, int m, int n) {
        if (pm > m || pn > n) return 0;
        if (pm == m || pn == n) return 1;

        int rightPaths = getUniquePathsBruteForce(pm, pn+1, m, n);
        int downPaths = getUniquePathsBruteForce(pm+1, pn, m, n);

        return rightPaths + downPaths;
    }
}
