package com.leetcode.topinterviewquestions;

public class SqrtX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int mySqrtNaive(int x) {
		for (long i = 1; i < Integer.MAX_VALUE; i++) {
			if (x == i * i)
				return (int) i;
			if (i * i > x)
				return (int) i - 1;
		}
		return 0;
	}

	public static int mySqrt(int x) {
		if (x <= 1)
			return x;
		// Binary Search Method
		int start = 1;
		int end = x / 2;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid == x / mid)
				return mid;
			if (mid > x / mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

}
