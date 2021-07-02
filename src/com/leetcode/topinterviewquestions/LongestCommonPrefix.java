package com.leetcode.topinterviewquestions;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		int ssi = 0;
		if (strs.length == 1)
			return strs[0];

		while (true) {
			for (int ai = 1; ai < strs.length; ai++) {
				if ((strs[ai].length() <= ssi || strs[0].length() <= ssi)
						|| (strs[0].charAt(ssi) != strs[ai].charAt(ssi))) {
					return strs[0].substring(0, ssi);
				}
			}
			ssi++;
		}
	}
}
