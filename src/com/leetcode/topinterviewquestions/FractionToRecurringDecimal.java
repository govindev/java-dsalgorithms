package com.leetcode.topinterviewquestions;

public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		int numerator = 1;
		int denominator = 6;
		System.out.println(fractionToDecimal(numerator, denominator));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		String res = (double) numerator / denominator + "";
		String fraction = res.substring(res.indexOf('.') + 1, res.length());

		String possibleFraction = "";
		int i = 0;
		while (i < fraction.length()) {
			possibleFraction = getFraction(fraction.substring(i, fraction.length()));
			if (possibleFraction != null) {
				fraction = fraction.substring(0, i) + possibleFraction;
				break;
			}
			i++;
		}
		if (fraction.equals("0")) {
			return res.substring(0, res.indexOf('.'));
		}
		return res.substring(0, res.indexOf('.') + 1) + fraction;
	}

	private static String getFraction(String fraction) {
		int leftStart = 0, leftEnd = 0;
		int rightStart = fraction.length() - 1, rightEnd = rightStart;
		while (leftEnd < rightStart) {
			String left = fraction.substring(leftStart, leftEnd + 1);
			String right = fraction.substring(rightStart, rightEnd + 1);
			if (left.equals(right)) {
				return "(" + left + ")";
			}
			leftEnd++;
			rightStart--;
		}
		return null;
	}

	public String fractionToDecimalNaive(int numerator, int denominator) {
		String res = (double) numerator / denominator + "";
		String fraction = res.substring(res.indexOf('.') + 1, res.length());

		String temp = "";
		temp += fraction.charAt(0);
		int i = 1;
		while (i + temp.length() <= fraction.length()) {
			if (fraction.charAt(i) == fraction.charAt(i - 1)) {
				fraction = "(" + fraction.charAt(i) + ")";
				break;
			} else if (fraction.charAt(i) == fraction.charAt(i + 1)) {
				fraction = temp + "(" + fraction.charAt(i) + ")";
				break;
			} else if (temp.equals(fraction.substring(i, i + temp.length()))) {
				fraction = "(" + temp + ")";
				break;
			}
			temp += fraction.charAt(i++);
		}
		if (fraction.equals("0")) {
			return res.substring(0, res.indexOf('.'));
		}
		return res.substring(0, res.indexOf('.') + 1) + fraction;
	}
}
