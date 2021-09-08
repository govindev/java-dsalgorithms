package com.interviews.freshworks;

//{34,65,66,32,12,32,45,77,87,98,5,4,65,99,1,32}
//
//n -2 ==> 87 + 98
//n -3 => 77,87,98
public class MaxConsecutiveSum {
	public static void main(String[] args) {
		int[] nums = { 34, 65, 66, 32, 12, 32, 45, 77, 87, 98, 5, 4, 65, 99, 1, 32, 200, 200 };
		int n = 3; // Sequence
		System.out.println("Maximum sum : " + findMaxSum(nums, n));
	}

	public static int findMaxSum(int[] nums, int n) {
		int max = 0;
		int current = 0;
		for (int i = 0; i < n; i++) {
			current += nums[i];
		}
		max = current;
		for (int i = n; i < nums.length; i++) {
			current -= nums[i - n];
			current += nums[i];
			max = Math.max(current, max);
		}
		return max;
	}
}
