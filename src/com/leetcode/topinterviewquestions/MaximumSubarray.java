package com.leetcode.topinterviewquestions;

public class MaximumSubarray {

	public static void main(String[] args) {
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int bestSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			bestSum = Math.max(nums[i], nums[i] + bestSum);
			max = Math.max(max, bestSum);
		}
		return max;
	}

}
