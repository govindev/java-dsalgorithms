package com.leetcode.topinterviewquestions;

public class FractionToDecimal {
	public static void main(String[] args) {
		String res = (double) 4 / 333 + "";
		String fraction = res.substring(res.indexOf('.') + 1, res.length());

		String current = "";
		current += fraction.charAt(0);
		int i = 1;
		while (i + current.length() <= fraction.length()) {
			if (current.equals(fraction.substring(i, i + current.length()))) {
				fraction = "(" + current + ")";
				break;
			}
			current += fraction.charAt(i++);
		}

		System.out.println(res);
		System.out.println(fraction);
	}
}
