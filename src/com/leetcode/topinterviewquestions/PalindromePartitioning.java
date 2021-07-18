package com.leetcode.topinterviewquestions;

import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "aab";
		partition(s);
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> curPals = new ArrayList<>();
		Map<String, Boolean> pals = new HashMap<>();
		dfs(s, 0, curPals, result, pals);
		return result;
	}

	public static void dfs(String s, int start, List<String> curPals, List<List<String>> result,
			Map<String, Boolean> pals) {
		if (start >= s.length()) {
			// Explored all the substrings
			result.add(new ArrayList<>(curPals));
			return;
		}
		for (int i = 1; start+i <= s.length(); i++) {
			String ss = s.substring(start, start + i);
			if (pals.containsKey(ss)) {
				if (pals.get(ss))
					curPals.add(ss);
			} else {
				if (isPalindrome(ss)) {
					pals.put(ss, true);
					curPals.add(ss);
				} else {
					pals.put(ss, false);
				}
			}
			if (pals.get(ss)) {
				// Explore remaining substrings in this way of partitioning
				dfs(s, start + i, curPals, result, pals);
				curPals.remove(curPals.size() - 1);
			}
		}
	}

	public static List<List<String>> partitionLengthWise(String s) {
		List<List<String>> result = new ArrayList<>();
		Map<String, Boolean> pals = new HashMap<>();
		int ssLen = 1;
		while (ssLen < s.length()) {
			int max = s.length() - ssLen + 1;
			List<String> curPals = new ArrayList<>();
			for (int i = 0; i < max; i++) {
				String ss = s.substring(i, i + ssLen);
				if (pals.containsKey(ss)) {
					if (pals.get(ss))
						curPals.add(ss);
				} else {
					if (isPalindrome(ss)) {
						pals.put(ss, true);
						curPals.add(ss);
					} else {
						pals.put(ss, false);
					}
				}
			}
			result.add(curPals);
			ssLen++;
		}
		return result;
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}