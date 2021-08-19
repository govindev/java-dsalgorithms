package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		System.out.println(rob(nums));
	}

	static int[] max;

	public static int rob(int[] nums) {
		max = new int[nums.length];
		Arrays.fill(max, -1);
		return maxRob(nums, 0);
	}

	public static int maxRob(int[] nums, int current) {
		if (current >= nums.length)
			return 0;
		if (max[current] != -1)
			return max[current];
		if (nums[current] <= 0)
			return maxRob(nums, current + 1);
		if (current == nums.length - 1)
			return nums[current];
		if (current == nums.length - 2)
			return Math.max(nums[current], nums[current + 1]);

		int maxAtCurrent = Math.max(maxRob(nums, current + 1), nums[current] + maxRob(nums, current + 2));
		max[current] = maxAtCurrent;
		return maxAtCurrent;

	}
}
