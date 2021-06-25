package com.leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] output = twoSum(nums, target);
		System.out.println("[" + output[0] + "," + output[1] + "]");
	}

	public static int[] twoSumNSquare(int[] nums, int target) {
		// order of n square solution
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					int[] output = new int[2];
					output[0] = i;
					output[1] = j;
					return output;
				}
			}
		}
		return null;
	}

	public static int[] twoSum(int[] nums, int target) {
		// order of n solution
		Map<Integer, Integer> tracker = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (tracker.containsKey(nums[i])) {
				int left = tracker.get(nums[i]);
				return new int[] { left, i };
			} else {
				tracker.put(target - nums[i], i);
			}
		}
		return new int[2];
	}

}
