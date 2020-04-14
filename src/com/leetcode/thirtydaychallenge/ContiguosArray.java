package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Contiguous Array
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
 * https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1: Input: [0,1] Output: 2 Explanation: [0, 1] is the longest
 * contiguous subarray with equal number of 0 and 1. Example 2: Input: [0,1,0]
 * Output: 2 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray
 * with equal number of 0 and 1. Note: The length of the given binary array will
 * not exceed 50,000.
 * 
 * @author Govind
 *
 */

public class ContiguosArray {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numsStrArray = br.readLine().split(",");
		int[] nums = new int[numsStrArray.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsStrArray[i]);
		}
		System.out.println("Max Length of Contiguous Subarray is :" + findMaxLength(nums));
	}

	/**
	 * Bruteforce approach
	 * 
	 * @param nums
	 * @return
	 */
	public static int findMaxLength(int[] nums) {
		int maxLength = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int noOfZeros = 0, noOfOnes = 0;
			if ((nums.length - 1 - i) < maxLength)
				break;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0) {
					noOfZeros++;
				} else {
					noOfOnes++;
				}
				if (noOfZeros == noOfOnes && (j - i + 1) > maxLength) {
					maxLength = j - i + 1;
				}
			}
		}
		return maxLength;
	}

}
