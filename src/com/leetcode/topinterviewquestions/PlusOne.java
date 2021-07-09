package com.leetcode.topinterviewquestions;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] output = plusOne(digits);
	}

	public static int[] plusOne(int[] digits) {
		// Most optimized
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 > 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				return digits;
			}
		}
		int[] output = new int[digits.length + 1];
		output[0] = 1;
		return output;
	}

	public static int[] plusOne1(int[] digits) {
		int overflow = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int v = digits[i] + overflow;
			if (v > 9) {
				digits[i] = 0;
				overflow = 1;
			} else {
				digits[i] = v;
				overflow = 0;
				break;
			}
		}
		if (overflow == 1) {
			int[] output = new int[digits.length + 1];
			output[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				output[i + 1] = digits[i];
			}
			return output;
		} else {
			return digits;
		}

	}

	public static int[] plusOneNaive(int[] digits) {
		// Doesn't work if there is a big number
		long sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum = sum * 10 + digits[i];
		}
		sum += 1;
		String sumStr = sum + "";
		int i = 0;
		int[] output = new int[sumStr.length()];
		while (i < sumStr.length()) {
			output[i] = Integer.parseInt(sumStr.charAt(i) + "");
			i++;
		}
		return output;
	}
}
