package com.leetcode.topinterviewquestions;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}

	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10;
			res += x % 10;
			x = x / 10;
		}
		if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
			return (int) res;
		} else {
			return 0;
		}
	}

}