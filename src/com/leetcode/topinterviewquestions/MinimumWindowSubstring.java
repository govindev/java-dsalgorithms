package com.leetcode.topinterviewquestions;

import java.util.*;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// String s = "ab";
		// String t = "A";
		// String s = "ADOBECODEBANC";
		// String t = "ABC";
		String s = "aaaaaaaaaaaabbbbbcdd";
		String t = "abcdd";
		System.out.println(minWindow(s, t));
	}

	public static String minWindow(String s, String t) {
		// Brute Force
		if (s.length() < t.length())
			return "";
		Map<Character, Integer> tChs = getChsMap(t);
		int inc = 0;
		while (t.length() + inc <= s.length()) {
			int start = 0, end = t.length() + inc;
			while (start <= s.length() - (t.length() + inc)) {
				String ss = s.substring(start, end);
				Map<Character, Integer> ssChs = getChsMap(ss);
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
