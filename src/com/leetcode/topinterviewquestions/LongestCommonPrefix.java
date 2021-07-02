package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefixNaive(String[] strs) {
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

	public static String longestCommonPrefix(String[] strs) {
		// Clean Code
		if (strs.length == 1)
			return strs[0];
		Arrays.sort(strs);
		int i = 0;
		String firstStr = strs[0];
		String lastStr = strs[strs.length - 1];
		while (i < firstStr.length()) {
			if (firstStr.charAt(i) == lastStr.charAt(i)) {
				i++;
			} else {
				break;
			}
		}
		return firstStr.substring(0, i);

	}
}
