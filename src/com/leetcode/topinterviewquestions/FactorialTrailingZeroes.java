package com.leetcode.topinterviewquestions;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int result = 0;
		for (int i = 5; i <= n; i = i * 5)
			result = result + n / i;
		return result;
	}

	public int trailingZeroesSpace(int n) {
		int zeros = n / 5;
		int current = 25;
		while (n >= current) {
			zeros += n / current;
			current = current * 5;
		}
		return zeros;
	}
}
