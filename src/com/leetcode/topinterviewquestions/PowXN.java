package com.leetcode.topinterviewquestions;

public class PowXN {
	public static void main(String[] args) {
		double x = 2.00000;
		int n = -2147483648;
		System.out.println(myPow(x, n));
	}

	public static double myPow(double x, int n) {
		double pow = 1;
		long nn = n;
		nn = (nn < 0) ? -1 * nn : nn;
		while (nn > 0) {
			if (nn % 2 == 0) {
				x = x * x;
				nn = nn / 2;
			} else {
				pow = pow * x;
				nn = nn - 1;
			}
		}
		if (n < 0) {
			return 1 / pow;
		}
		return pow;
	}
}