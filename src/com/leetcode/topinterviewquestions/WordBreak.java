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
		// return dfsDm(s, set, s.length());

		int[] dp = new int[301];
		Arrays.fill(dp, -1);
		return (dfs(0, s, set, dp) == 1) ? true : false;
	}

	public static int dfs(int ssStart, String s, Set<String> wordDict, int[] dp) {
		// With the help of DP
		// Memorizing results of already visited paths
		if (ssStart == s.length())
			return 1;
		if (dp[ssStart] != -1)
			return dp[ssStart];
		String temp = "";
		for (int i = ssStart; i < s.length(); i++) {
			temp += s.charAt(i);
			if (wordDict.contains(temp)) {
				if (dfs(i + 1, s, wordDict, dp) == 1)
					return dp[ssStart] = 1;
			}
		}
		return dp[ssStart] = 0;
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
