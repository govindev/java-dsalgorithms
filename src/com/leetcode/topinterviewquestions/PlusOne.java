package com.leetcode.topinterviewquestions;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] output = plusOne(digits);
	}

	public static int[] plusOne(int[] digits) {
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
