package com.leetcode.topinterviewquestions;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}
}
