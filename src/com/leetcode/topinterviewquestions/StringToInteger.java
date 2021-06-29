package com.leetcode.topinterviewquestions;

public class StringToInteger {
	public static void main(String[] args) {
		// String s = " -42";
		String s = "9223372036854775808";
		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {
		s = s.trim();
		long number = 0;
		int sign = 1;
		boolean isSignConsidered = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9') {
				number *= 10;
				int k = c - '0';
				number = number + k;
				if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
					if (sign > 0)
						return Integer.MAX_VALUE;
					return Integer.MIN_VALUE;

				}
				isSignConsidered = true;
			} else if (number > 0) {
				break;
			} else if (c == '-' && !isSignConsidered) {
				sign = -1;
				isSignConsidered = true;
			} else if (c == '+' && !isSignConsidered) {
				sign = +1;
				isSignConsidered = true;
			} else {
				return 0;
			}
		}
		number *= sign;
		return (int) number;
	}
}
