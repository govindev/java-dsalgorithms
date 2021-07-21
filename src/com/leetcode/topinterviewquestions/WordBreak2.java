package com.leetcode.topinterviewquestions;

import java.util.*;

public class WordBreak2 {
	public static void main(String[] args) {
//		String s = "catsanddog";
//		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

		String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		wordBreak(s, wordDict);
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		List<String> validStrings = new ArrayList<>();
		getValidStrings(s, set, 0, validStrings, "");
		return validStrings;
	}

	public static void getValidStrings(String s, Set<String> dict, int start, List<String> validStrings, String current) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (dict.contains(sb.toString())) {
				if (i + 1 == s.length()) {
					validStrings.add(current + sb.toString());
				} else {
					getValidStrings(s, dict, i+1, validStrings, current + sb.toString() + " ");
				}

			}
		}
	}
}