package com.leetcode.topinterviewquestions;

public class SortColors {
	public void sortColors(int[] nums) {
		// Dutch National Flag Algorithm
		int low = 0, mid = 0, high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				// Swap with low
				int temp = nums[mid];
				nums[mid] = nums[low];
				nums[low] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				// Swap with high
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
	}

	public void sortColors2Passes(int[] nums) {
		// 2 passes
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
