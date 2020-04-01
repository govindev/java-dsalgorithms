package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1 Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 * 
 * @author Govind
 *
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			boolean isSingle = true;
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] == nums[j]) {
					isSingle = false;
					break;
				}
			}
			if (isSingle)
				return nums[i];
		}
		return 0;
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String[] numsInStr = br.readLine().trim().split(" ");
		int[] nums = new int[length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsInStr[i]);
		}
		// Find the single number
		System.out.println("Single number is : " + singleNumber(nums));
	}
}
