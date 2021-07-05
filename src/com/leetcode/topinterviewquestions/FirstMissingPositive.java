package com.leetcode.topinterviewquestions;

public class FirstMissingPositive {
	public static void main(String[] args) {

	}

	public int firstMissingPositive(int[] nums) {
		// This works in a scenario where 
		// 1. There is only one missing number in the given positive numbers
		int smallest = Integer.MAX_VALUE;
		int highest = Integer.MIN_VALUE;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (nums[i] < smallest)
					smallest = nums[i];
				if (nums[i] > highest)
					highest = nums[i];
				sum += nums[i];
				count++;
			}
		}
		// Supposed to be length
		int pArrLength = count + 1;
		int supposedToBeSum = pArrLength * (smallest - 1) + (pArrLength * (pArrLength + 1)) / 2;
		return (smallest > 1) ? 1 : (supposedToBeSum - sum);
	}
}
