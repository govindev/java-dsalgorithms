package com.leetcode.topinterviewquestions;

public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int i = 0;
		int result = 0;
		while (i < 32) {
			result = result << 1;
			if ((n & 1) > 0) {
				result = result | 1; // simply do result++;
			}
			n = n >> 1;
			i++;
		}
		return result;
	}
}
