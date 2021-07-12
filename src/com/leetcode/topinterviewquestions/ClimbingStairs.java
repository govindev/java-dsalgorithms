package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] dp;

	public int climbStairs(int n) {
		dp = new int[n + 2];
		Arrays.fill(dp, -1);
		return findWays(0, n);
	}

	public int findWays(int current, int top) {
		if (current == top) {
			return 1;
		}
		if (current > top) {
			return 0;
		}

		int oneStepWays = (dp[current + 1] > -1 ? dp[current + 1] : findWays(current + 1, top));
		dp[current + 1] = oneStepWays;

		int twoStepWays = (dp[current + 2] > -1 ? dp[current + 2] : findWays(current + 2, top));
		dp[current + 2] = twoStepWays;

		dp[current] = oneStepWays + twoStepWays;
		return dp[current];
	}
}
