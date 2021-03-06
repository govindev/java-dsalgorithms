package com.leetcode.topinterviewquestions;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend = 2147483647;
		int divisor = 1;
		System.out.println(divide(dividend, divisor));
	}

	private static int divide(int dividend, int divisor) {
		// Double the count
		if (dividend == 1 << 31 && divisor == -1)
			return Integer.MAX_VALUE;

		boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int result = 0;
		while (dividend - divisor >= 0) {
			int count = 0;
			while (dividend - (divisor << 1 << count) >= 0) {
				count++;
			}
			result += 1 << count;
			dividend -= divisor << count;
		}
		return sign ? result : -result;
	}

	private static int divideNaive(int dividend, int divisor) {
		// Brute force
		// Wrong way as we are using multiplication, but we are not supposed to use it
		long m = (divisor > 0) ? 1 : -1;
		long n = (dividend > 0) ? 1 : -1;
		long divisorL = divisor * m;
		long dividendL = dividend * n;
		long sum = divisorL;
		long i = 1;
		while (sum < dividendL) {
			sum += divisorL;
			i++;
		}
		if (sum > dividendL)
			i--;
		if (i * m * n > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (i * m * n < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) (i * m * n);
	}
}
