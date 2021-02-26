package com.challenges.leetcode.twentyone.feb;

import java.util.Arrays;

/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3652/
 * 
 * Shortest unsorted continuous sub array
 * 
 * @author Govind
 *
 */
public class ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {
		int[] nums = { 2, 1 };
		System.out.println(findUnsortedSubarray(nums));
	}

	/**
	 * Accepted solution
	 * 
	 * @param nums
	 * @return
	 */
	public static int findUnsortedSubarray(int[] nums) {
		int[] sNums = nums.clone();
		Arrays.sort(sNums);
		int subArrStart = -1;
		int subArrEnd = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != sNums[i]) {
				if (subArrStart == -1) {
					subArrStart = i;
				}
				subArrEnd = i;
			}
		}
		if (subArrStart >= 0 && subArrEnd >= 0) {
			return subArrEnd + 1 - subArrStart;
		}
		return 0;
	}

	/**
	 * Fails for some of the test cases Unaccepted
	 * 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray1(int[] nums) {
		int sortingStart = -1;
		int sortingEnd = -1;
		int greatest = nums[0];
		for (int i = 0; i < nums.length; i++) {
			Boolean isSorted = true;
			if (i > 0 && ((nums[i] < nums[i - 1]) || (nums[i] < greatest))) {
				isSorted = false;
				sortingStart = (sortingStart > -1) ? sortingStart : i - 1;
				if (sortingStart == i - 1)
					for (int j = i - 2; j >= 0; j--) {
						if (nums[i - 1] == nums[j]) {
							sortingStart = j;
						} else
							break;
					}
				sortingEnd = i;
			}
			if (nums[i] > greatest) {
				greatest = nums[i];
			}
			if (i < (nums.length - 1) && nums[i] > nums[i + 1]) {
				isSorted = false;
				sortingEnd = i + 1;
				sortingStart = (sortingStart > -1) ? sortingStart : i;
			}
		}
		if (sortingEnd >= 0 && sortingStart >= 0) {
			return sortingEnd - sortingStart + 1;
		}
		return 0;
	}
}
