package com.leetcode.topinterviewquestions;

public class SortColors {
	public void sortColors(int[] nums) {
		int redCount = 0;
		int whiteCount = 0;
		int blueCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (0 == nums[i])
				redCount++;
			if (1 == nums[i])
				whiteCount++;
			if (2 == nums[i])
				blueCount++;
		}
		int i = 0;
		while (i < redCount) {
			nums[i] = 0;
			i++;
		}
		while (i < redCount + whiteCount) {
			nums[i] = 1;
			i++;
		}
		while (i < redCount + whiteCount + blueCount) {
			nums[i] = 2;
			i++;
		}
	}
}
