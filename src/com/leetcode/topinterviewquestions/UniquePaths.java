package com.leetcode.topinterviewquestions;

public class UniquePaths {

	public static void main(String[] args) {

	}

	public static int uniquePaths(int m, int n) {
		return uniquePaths(m - 1, n - 1, 0, 0);
	}

	public static int uniquePaths(int m, int n, int ms, int ns) {
		// Brute force , recursive solution
		if (m == ms && n == ns) {
			return 1;
		}
		if (ms > m || ns > n) {
			return 0;
		}
		int downPaths = uniquePaths(m, n, ms + 1, ns);
		int rightPaths = uniquePaths(m, n, ms, ns + 1);
		return (downPaths + rightPaths);
	}

}
