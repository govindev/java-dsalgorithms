package com.leetcode.topinterviewquestions;

public class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				int first = mid, last = mid;
				while (first >= low) {
					if (first - 1 >= 0 && nums[first - 1] == target) {
						first--;
						continue;
					}
					break;
				}
				while (last <= high) {
					if (last + 1 <= high && nums[last + 1] == target) {
						last++;
						continue;
					}
					break;
				}
				return new int[] { first, last };
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
