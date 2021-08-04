package com.leetcode.topinterviewquestions;

import java.util.*;

public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		int numerator = -50;
		int denominator = 8;
		System.out.println(fractionToDecimal(numerator, denominator));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		boolean isNegative = ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0));
		StringBuilder decimal = new StringBuilder();
		Map<Long, Integer> quos = new HashMap<>();
		long numeratorL = Math.abs((long)numerator);
		long denominatorL = Math.abs((long)denominator);
		long quo = numeratorL / denominatorL;
		decimal.append(quo);
		numeratorL = numeratorL % denominatorL;
		if (numeratorL != 0) {
			decimal.append(".");
		}

		int quoIndex = 0;
		while (numeratorL != 0) {
			numeratorL *= 10;
			quo = numeratorL / denominatorL;
			if (!quos.containsKey(numeratorL)) {
				decimal.append(quo);
				quos.put(numeratorL, ++quoIndex);
			} else {
				int index = quos.get(numeratorL) + decimal.indexOf(".");
				decimal.insert(index, "(");
				decimal.append(")");
				break;
			}
			numeratorL = numeratorL % denominatorL;
		}
		if (isNegative)
			decimal.insert(0, '-');

		return decimal.toString();

	}

	public static String fractionToDecimalImproved(int numerator, int denominator) {
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
