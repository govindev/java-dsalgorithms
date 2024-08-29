package com.sdesheet.blind;

import java.util.Arrays;

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

    public int getUniquePathsBruteForce(int row, int col, int m, int n) {
        if (row == m || col == n) return 0;
        if (row == m-1 || col == n-1) return 1;
        return getUniquePathsBruteForce(row+1, col, m, n) + getUniquePathsBruteForce(row, col+1, m, n);
    }

    public int getUniquePathsDp(int row, int col, int m, int n, int[][] dp) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (row == m || col == n) return 0;
        if (row == m-1 || col == n-1) return 1;

        dp[row][col] = getUniquePathsDp(row+1, col, m, n, dp) + getUniquePathsDp(row, col+1, m, n, dp);
        return dp[row][col];
    }
}
