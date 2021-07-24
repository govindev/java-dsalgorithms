package com.leetcode.topinterviewquestions;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		// Log time
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public int findPeakElementLinearTime(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i - 1 < 0 && i + 1 > nums.length - 1)
				return 0;
			else if (i - 1 < 0) {
				if (nums[i] > nums[i + 1])
					return i;
			} else if (i + 1 > nums.length - 1) {
				if (nums[i] > nums[i - 1])
					return i;
			} else if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1])
				return i;
		}
		return 0;
	}
}
