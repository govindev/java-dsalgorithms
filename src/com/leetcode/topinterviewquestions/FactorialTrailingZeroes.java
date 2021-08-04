package com.leetcode.topinterviewquestions;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int zeros = n / 5;
		int current = 25;
		while (n >= current) {
			zeros += n / current;
			current = current * 5;
		}
		return zeros;
	}
}
