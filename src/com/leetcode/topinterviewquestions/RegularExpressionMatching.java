package com.leetcode.topinterviewquestions;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		String s = "aa";
		String p = "a*";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		int pPtr = 0, sPtr = 0;
		while (sPtr < s.length()) {
			if (pPtr >= p.length()) {
				return false;
			}
			if (!isCurrentAManyPtr(pPtr, p)) {
				if (p.charAt(pPtr) == '.' || p.charAt(pPtr) == s.charAt(sPtr)) {
					pPtr++;
					sPtr++;
					continue;
				} else {
					return false;
				}
			} else {
				if (p.charAt(pPtr) == '.' || p.charAt(pPtr) == s.charAt(sPtr)) {
					sPtr++;
					continue;
				} else {
					pPtr = isCurrentAMinOnePtr(pPtr, p) ? pPtr + 3 : pPtr + 2;
					continue;
				}
			}
		}
		while (pPtr < p.length()) {
			if (isCurrentAManyPtr(pPtr, p)) {
				pPtr = isCurrentAMinOnePtr(pPtr, p) ? pPtr + 3 : pPtr + 2;
			} else {
				break;
			}
		}
		if (pPtr < p.length()) {
			return false;
		}
		return true;
	}

	public static boolean isCurrentAManyPtr(int pPtr, String p) {
		if (pPtr + 1 < p.length() && p.charAt(pPtr) != '*' && p.charAt(pPtr + 1) == '*') {
			return true;
		}
		return false;
	}

	public static boolean isCurrentAMinOnePtr(int pPtr, String p) {
		if (pPtr + 1 < p.length() && pPtr + 2 < p.length() && p.charAt(pPtr) != '*' && p.charAt(pPtr + 1) == '*'
				&& p.charAt(pPtr + 2) == p.charAt(pPtr)) {
			return true;
		}
		return false;
	}
}
