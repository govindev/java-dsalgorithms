package com.leetcode.topinterviewquestions;

public class WildcardMatching {
	public static void main(String[] args) {
		String s = "abcabczzzde";
		String p = "*abc???de*";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
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
