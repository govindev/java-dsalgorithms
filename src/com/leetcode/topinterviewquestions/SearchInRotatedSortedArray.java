package com.leetcode.topinterviewquestions;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 4 };
		int target = 3;
		System.out.println(search(nums, target));

	}

	public static int search(int[] nums, int target) {
		// Better solution
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == nums[mid])
				return mid;
			if (nums[low] <= nums[mid]) {
				// Left half is sorted
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// Right half is sorted
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int searchNaive(int[] nums, int target) {
		return find(nums, 0, nums.length - 1, target);
	}

	public static int find(int[] nums, int low, int high, int target) {
		int mid = (low + high) / 2;
		if (target == nums[mid])
			return mid;
		// One of the portion is always sorted
		if (nums[mid - 1] >= nums[low] && target <= nums[mid - 1] && target >= nums[low]) {
			// Left portion is sorted
			return find(nums, low, mid - 1, target);
		} else {
			// Right portion is sorted
			return find(nums, mid + 1, high, target);
		}
	}
}
