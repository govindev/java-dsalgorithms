package com.leetcode.topinterviewquestions;

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		String[] words = new String[] { "leet", "code" };
		List<String> wordDict = Arrays.asList(words);
		String s = "leetcode";
		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		// return dfsIm(s, set, 1);
		return dfsDm(s, set, s.length());
	}

	public static boolean dfsIm(String s, Set<String> wordDict, int ssEnd) {
		// Increasing Manner
		// Giving timeout
		if (ssEnd > s.length())
			return false;
		if (dfsIm(s, wordDict, ++ssEnd))
			return true;
		if (wordDict.contains(s.substring(0, --ssEnd))) {
			if (ssEnd == s.length())
				return true;
			// Match
			// Ignore the substring from the string
			if (dfsIm(s.substring(ssEnd, s.length()), wordDict, 1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean dfsDm(String s, Set<String> wordDict, int ssEnd) {
		// Decreasing manner
		// Giving timeout
		if (ssEnd < 0)
			return false;
		if (wordDict.contains(s.substring(0, ssEnd))) {
			wordDict.add(s.substring(0, ssEnd));
			if (ssEnd == s.length())
				return true;
			// Match
			// Ignore the substring from the string
			if (dfsDm(s.substring(ssEnd, s.length()), wordDict, s.length() - ssEnd)) {
				return true;
			}
		}
		return dfsDm(s, wordDict, --ssEnd);
	}
}
