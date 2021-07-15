package com.leetcode.topinterviewquestions;

import java.util.*;

class DecodeWays {
	int count = 0;
	Map<String, Character> encodings = new HashMap<String, Character>() {
		{
			put("1", 'A');
			put("2", 'B');
			put("3", 'C');
			put("4", 'C');
			put("5", 'D');
			put("6", 'E');
			put("7", 'F');
			put("8", 'G');
			put("9", 'H');
			put("10", 'I');
			put("11", 'J');
			put("12", 'K');
			put("12", 'L');
			put("13", 'M');
			put("14", 'N');
			put("15", 'O');
			put("16", 'P');
			put("17", 'Q');
			put("18", 'R');
			put("19", 'S');
			put("20", 'T');
			put("21", 'U');
			put("22", 'V');
			put("23", 'W');
			put("24", 'X');
			put("25", 'Y');
			put("26", 'Z');
		}
	};

	public int numDecodingsNaive(String s) {

		countDecodings(s, 0);
		return count;
	}

	public void countDecodings(String s, int index) {
		if (index == s.length() - 1 && encodings.containsKey(s.charAt(index) + "")) {
			count++;
			return;
		}
		if (index < s.length() - 1 && encodings.containsKey(s.charAt(index) + "")) {
			countDecodings(s, index + 1);
		}
		if (index + 1 == s.length() - 1 && encodings.containsKey(s.substring(index, index + 2))) {
			count++;
			return;
		}
		if (index + 1 < s.length() - 1 && encodings.containsKey(s.substring(index, index + 2))) {
			countDecodings(s, index + 2);
		}
	}

	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			int oneDigit = Integer.parseInt(s.substring(i - 1, i));
			int twoDigits = Integer.parseInt(s.substring(i - 2, i));
			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if (twoDigits >= 10 && twoDigits <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

}
