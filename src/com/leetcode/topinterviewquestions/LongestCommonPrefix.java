package com.leetcode.topinterviewquestions;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];
		for (int index = 1; index < strs.length; index++) {
			while (strs[index].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	public String longestCommonPrefixMyBest(String[] strs) {
		// Best approach
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String current = strs[i];
			if (current.length() < prefix.length()) {
				current = prefix;
				prefix = strs[i];
			}
			int j = 0;
			for (; j < prefix.length(); j++) {
				if (prefix.charAt(j) != current.charAt(j)) {
					break;
				}
			}
			if (j < prefix.length()) {
				prefix = prefix.substring(0, j);
			}
			if (j == 0)
				break;
		}
		return prefix;
	}

	public String longestCommonPrefixSortingApproach(String[] strs) {
		//
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

	public String longestCommonPrefixNaive(String[] strs) {
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
