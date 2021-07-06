package com.leetcode.topinterviewquestions;

public class WildcardMatching {
	public static void main(String[] args) {
		String s = "abcabczzzde";
		String p = "*abc???de*";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();

		// replace multiple * with one *
		// e.g a**b***c -> a*b*c
		int writeIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[writeIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[writeIndex++] = pattern[i];
				isFirst = true;
			}
		}

		boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

		if (writeIndex > 0 && pattern[0] == '*') {
			T[0][1] = true;
		}
		T[0][0] = true;

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i][j - 1] || T[i - 1][j];
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[str.length][writeIndex];

	}

	public static boolean isMatchNaive(String s, String p) {
		// Partial Solution.
		// 1466 / 1811 test cases passed.
		int pI = 0, sI = 0, sMax = s.length() - 1, pMax = p.length() - 1;
		while (pI <= pMax && sI <= sMax) {
			if (p.charAt(pI) == '*') {
				while (pI <= pMax && p.charAt(pI) == '*') {
					pI++;
					if (pI >= pMax)
						return true;
				}
				while (sI <= sMax) {
					if (p.charAt(pI) == s.charAt(sI)) {
						break;
					}
					sI++;
					if (sI > sMax)
						return false;
				}
				sI++;
				pI++;
			} else if (p.charAt(pI) == '?') {
				pI++;
				sI++;
			} else {
				if (p.charAt(pI) == s.charAt(sI)) {
					pI++;
					sI++;
				} else {
					return false;
				}
			}
		}
		while (pI <= pMax && p.charAt(pI) == '*') {
			pI++;
			if (pI >= pMax)
				return true;
		}
		if (sI > sMax && pI > pMax)
			return true;
		return false;
	}
}
