package com.leetcode.topinterviewquestions;

import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// String s = "ab";
		// String t = "A";
		String s = "ADOBECODEBANC";
		String t = "ABC";
		// String s = "aaaaaaaaaaaabbbbbcdd";
		// String t = "abcdd";
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";
		Map<Character, Integer> tChs = getChsMap(t);
		String ss = null;

		Map<Character, Integer> ssChs = new HashMap<>();
		int left = 0, right = left;
		Character ch = s.charAt(left);
		ssChs.put(ch, 1);
		while (left <= right) {
			if (areTheChsFound(ssChs, tChs)) {
				// Found
				if (ss == null || ss.length() > right - left) {
					ss = s.substring(left, right + 1);
				}

				Character leftCh = s.charAt(left);
				// Remove the left character
				ssChs.put(leftCh, ssChs.get(leftCh) - 1);
				// Move the left pointer
				left++;
			} else {
				// Move the right pointer
				right++;
				if (right < s.length()) {
					Character rightCh = s.charAt(right);
					if (ssChs.get(rightCh) == null) {
						ssChs.put(rightCh, 1);
					} else {
						ssChs.put(rightCh, ssChs.get(rightCh) + 1);
					}
				} else { break; }
			}
		}
		return ss;
	}

	public static String minWindowDp(String s, String t) {
		// Brute Force
		if (s.length() < t.length())
			return "";
		Map<Character, Integer> tChs = getChsMap(t);

		// DP Solution
		Map<Integer, Map<Character, Integer>> dp = new HashMap<>();

		int inc = 0;
		while (t.length() + inc <= s.length()) {
			int start = 0, end = t.length() + inc;
			while (start <= s.length() - (t.length() + inc)) {
				String ss = s.substring(start, end);

				Map<Character, Integer> ssChs;
				// If Map is there for the substring
				if (dp.get(start + end - 1) != null) {
					ssChs = dp.get(start + end - 1);
					Character ch = ss.charAt(ss.length() - 1);
					if (ssChs.containsKey(ch)) {
						ssChs.put(ch, ssChs.get(ch) + 1);
					} else {
						ssChs.put(ch, 1);
					}
				} else {
					ssChs = getChsMap(ss);
				}
				dp.put(start + end, ssChs);

				if (areTheChsFound(ssChs, tChs)) {
					return ss;
				}
				start++;
				end++;
			}
			inc++;
		}
		return "";
	}

	public static Map<Character, Integer> getChsMap(String str) {

		Map<Character, Integer> strChs = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (strChs.containsKey(ch)) {
				strChs.put(ch, strChs.get(ch) + 1);
			} else {
				strChs.put(ch, 1);
			}
		}
		return strChs;
	}

	public static boolean areTheChsFound(Map<Character, Integer> strChs, Map<Character, Integer> tChs) {
		Set<Character> keySet = tChs.keySet();
		for (Character ch : keySet) {
			if (strChs.get(ch) == null || strChs.get(ch) < tChs.get(ch)) {
				return false;
			}
		}
		return true;
	}
}
