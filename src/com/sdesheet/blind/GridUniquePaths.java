package com.sdesheet.blind;

import java.util.Arrays;

public class GridUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return uniquePaths(0, 0, m, n, dp);
    }

    public int uniquePaths (int row, int col, int m, int n, int[][] dp) {
        if (dp[row][col] == -1) {
            if (row == m-1 || col == n-1) {
                dp[row][col] = 1;
            } else {
                int rightPaths = uniquePaths(row, col+1, m, n, dp);
                int bottomPaths = uniquePaths(row+1, col, m, n, dp);

                dp[row][col] = rightPaths + bottomPaths;
            }
        }
        return dp[row][col];
    }
}
