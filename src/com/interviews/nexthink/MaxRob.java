package com.interviews.nexthink;

public class MaxRob {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 1 };
		int[] nums2 = { 2, 7, 9, 3, 1 };
		int[] nums3 = { 1, 7, 5, 8, 9 };
		int[] nums4 = { 1, 0, 2, 1, 0 };
		int[] nums5 = { 9, 5, 1, 6, 8 };
		if (findMaxRob(nums1, 0) == 4) {
			System.out.println("Test case 1 passed");
		}
		if (findMaxRob(nums2, 0) == 12) {
			System.out.println("Test case 2 passed");
		}
		if (findMaxRob(nums3, 0) == 15) {
			System.out.println("Test case 3 passed");
		}
		if (findMaxRob(nums4, 0) == 3) {
			System.out.println("Test case 4 passed");
		}
		if (findMaxRob(nums5, 0) == 18) {
			System.out.println("Test case 5 passed");
		}

	}

	public static int findMaxRob(int[] nums, int current) {
		if (current >= nums.length) {
			return 0;
		}
		if (current == nums.length - 1 || current == nums.length - 2) {
			return nums[current];
		}
		int currentMax = nums[current] + findMaxRob(nums, current + 2);
		int next = current + 1;
		int nextMax = nums[next] + findMaxRob(nums, next + 2);
		return Math.max(currentMax, nextMax);
	}

}
