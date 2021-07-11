package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {

	}

	public static int uniquePathsUsingCombinations(int m, int n) {
		int N = (m - 1) + (n - 1);
		int r = m - 1; // n - 1;
		// Now find NCr
		// Formuale is N * N - 1 * N - 2 / r * r - 1 * r - 2 ==== If r is 3;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
		return (int) res;
	}

	public static int uniquePaths(int m, int n) {
//		return uniquePaths(m - 1, n - 1, 0, 0);

		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return uniquePaths(m - 1, n - 1, 0, 0, dp);
	}

	public int uniquePaths(int m, int n, int ms, int ns) {
		// Brute force , recursive solution
		if (m == ms && n == ns) {
			return 1;
		}
		if (ms > m || ns > n) {
			return 0;
		}
		// int downPaths = uniquePaths(m, n, ms+1, ns);
		// int rightPaths = uniquePaths(m, n, ms, ns+1);
		// return (downPaths + rightPaths);
		return uniquePaths(m, n, ms + 1, ns) + uniquePaths(m, n, ms, ns + 1);
	}

	public static int uniquePaths(int m, int n, int ms, int ns, int[][] dp) {
		// Brute force , recursive solution
		if (m == ms && n == ns) {
			return 1;
		}
		if (ms > m || ns > n) {
			return 0;
		}
		if (dp[ms][ns] != -1)
			return dp[ms][ns];

		return dp[ms][ns] = uniquePaths(m, n, ms + 1, ns, dp) + uniquePaths(m, n, ms, ns + 1, dp);
	}

}
