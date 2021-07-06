package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}

	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] < 1 || nums[i] > nums.length || nums[i] == i + 1) {
				i++;
				continue;
			}

			int e = nums[i];
			if (nums[e - 1] != e) {
				// Swap
				nums[i] = nums[e - 1];
				nums[e - 1] = e;
			} else
				i++;
		}
		i = 0;
		for (; i < nums.length; i++)

		{
			if (nums[i] != i + 1)
				return i + 1;
		}
		return i + 1;
	}

	public int firstMissingPositiveBetter(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length && nums[i] < 1) {
			i++;
		}
		if (i >= nums.length || nums[i] != 1)
			return 1;
		int j = 2;
		i++;
		while (i < nums.length) {
			if (nums[i] == nums[i - 1]) {
				i++;
				continue;
			}
			if (j == nums[i]) {
				j++;
				i++;
			} else {
				return j;
			}
		}
		return j;
	}

	public int firstMissingPositiveNaive(int[] nums) {
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
