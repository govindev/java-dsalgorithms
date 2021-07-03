package com.leetcode.topinterviewquestions;

public class ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "eeeeeb";
		String needle = "eeeb";
		System.out.println(strStrNaive(haystack, needle));
	}

	public static int strStrNaive(String haystack, String needle) {
		int hl = haystack.length();
		int nl = needle.length();
		if (needle.equals(haystack))
			return 0;

		for (int i = 0; i <= hl - nl; i++) {
			int k = i;
			int j = 0;
			for (; j < nl; j++) {
				if (haystack.charAt(k) == needle.charAt(j)) {
					k++;
				} else {
					break;
				}
			}
			if (j == nl)
				return i;
		}
		return -1;
	}

	public static int strStrNaiveUsingSubstring(String haystack, String needle) {
		// Using the substring method of the java string
		int hl = haystack.length();
		int nl = needle.length();
		if (needle.equals(haystack))
			return 0;
		for (int i = 0; i < hl - nl + 1; i++) {
			if (needle.equals(haystack.substring(i, i + nl)))
				return i;
		}
		return -1;
	}

}
