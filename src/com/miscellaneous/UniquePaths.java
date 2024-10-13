package com.miscellaneous;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePaths(0, 0, m, n, dp);
    }

    private int uniquePaths(int i, int j, int rows, int cols, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == rows-1 || j == cols-1) {
            dp[i][j] = 1;
        } else {
            int rightPaths = uniquePaths(i, j+1, rows, cols, dp);
            int bottomPaths = uniquePaths(i+1, j, rows, cols, dp);
            dp[i][j] = rightPaths+bottomPaths;
        }
        return dp[i][j];
    }
}
