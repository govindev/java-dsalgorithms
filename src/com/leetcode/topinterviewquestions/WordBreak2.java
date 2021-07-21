package com.leetcode.topinterviewquestions;

import java.util.*;

public class WordBreak2 {
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		wordBreak(s, wordDict);
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		List<String> validStrings = new ArrayList<>();
		getValidStrings(s, set, 0, validStrings);
		return validStrings;
	}

	public static String getValidStrings(String s, Set<String> dict, int start, List<String> validStrings) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (dict.contains(sb.toString())) {
				if (i + 1 == s.length()) {
					return sb.toString();
				} else {
					String following = getValidStrings(s, dict, i + 1, validStrings);
					if (following != null && !following.equals("")) {
						String formatted = sb.toString() + " " + following;
						if (start != 0)
							return formatted;
						else
							validStrings.add(formatted);
					}
				}

			}
		}
		return null;
	}
}