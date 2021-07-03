package com.leetcode.topinterviewquestions;

public class ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "adsgwadsxdsgwadsgz";
		String needle = "dsgwadsgz";
		System.out.println(strStr(haystack, needle));
	}

	public static int[] constructLookupArray(String pattern) {
		// Construct and return the lookup array
		int[] lookup = new int[pattern.length()];
		if (pattern.length() < 1)
			return lookup;
		int i = 0;
		lookup[i] = 0;
		for (int j = 1; j < pattern.length();) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lookup[j] = i + 1;
				i++;
				j++;
			} else {
				if (i != 0) {
					i = lookup[i - 1];
				} else {
					lookup[j] = 0;
					j++;
				}
			}
		}

		return lookup;
	}

	public static int strStr(String haystack, String needle) {
		if (haystack.equals(needle) || needle.equals(""))
			return 0;
		int[] lookup = constructLookupArray(needle);
		int j = 0;
		int hl = haystack.length();
		int nl = needle.length();
		for (int i = 0; i < hl && j < nl; i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
				if (j == needle.length()) {
					return i - j + 1;
				}
			} else {
				if (j > 0) {
					j = lookup[j - 1];
					i--;
				}

			}
		}
		return -1;
	}

	// IGNORE BELOW.

	public static int strStrNaive(String haystack, String needle) {
		// Naive solution. time complexity is order of m * n
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
