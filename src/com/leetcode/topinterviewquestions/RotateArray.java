package com.leetcode.topinterviewquestions;

import java.util.*;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = new int[] { -1, -100, 3, 99 };
		int k = 2;
		rotate(nums, k);
	}

	public static void rotate(int[] nums, int k) {
		// Strategy here is to reverse all the elements
		// Then reverse elements from 0 to k - 1;
		// Then reverse elements from k to len -1;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public void rotateJump(int[] nums, int k) {
		// This works
		// But there will be situations that i and to keeps repeating, in that case it
		// can never go through all the elements
		while (k > nums.length)
			k = k - nums.length;
		int i = 0, j = 0;
		int val = nums[i];
		while (j < nums.length) {
			int to = i + k;
			if (to >= nums.length) {
				to -= nums.length;
			}
			int temp = nums[to];
			nums[to] = val;
			val = temp;
			i = to;
			j++;
		}
	}

	public void rotateExtraSpace(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		// K can be greater than the length,
		// For len = 7, k = 3 or 10 is gonna give the same result
		while (k > nums.length)
			k = k - nums.length;
		for (int i = nums.length - k; i < nums.length; i++) {
			res.add(nums[i]);
		}
		for (int i = 0; i < nums.length - k; i++) {
			res.add(nums[i]);
		}
		int i = 0;
		for (Integer num : res) {
			nums[i++] = num;
		}
	}
}
