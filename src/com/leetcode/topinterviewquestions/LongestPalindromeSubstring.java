package com.leetcode.topinterviewquestions;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "babab";
		// System.out.println(isPalindrome(s, 0, s.length() - 1));
		System.out.println(longestPalindromeBetter1(s));
	}

	private static String longestPalindrome(String s, int left, int right) {
		if (left == right) {
			return s.charAt(left) + "";
		}
		if (left > right) {
			return null;
		}
		if (isPalindrome(s, left, right)) {
			return s.substring(left, right + 1);
		} else {
			String longestPalindrome1 = longestPalindrome(s, left, right - 1);
			String longestPalindrome2 = longestPalindrome(s, left + 1, right);
			return longestPalindrome1.length() > longestPalindrome2.length() ? longestPalindrome1 : longestPalindrome2;
		}
	}

	private static String longestPalindromeBetter1(String s) {
		return longestPalindrome(s, 0, s.length() - 1);
	}

	public String longestPalindromeOld(String s) {
		int longestPalStart = 0, longestPalEnd = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = s.length() - 1; j >= i + 1; j--) {
				if (isPalindrome(s, i, j)) {
					System.out.println("Palindrome : " + s.substring(i, j + 1));
					if (j - i + 1 > longestPalEnd - longestPalStart + 1) {
						longestPalStart = i;
						longestPalEnd = j;
					}

				}
			}
		}
		return s.substring(longestPalStart, longestPalEnd + 1);
	}

	private static boolean isPalindrome(String s, int left, int right) {
		// System.out.println("isPalindrome : " + s.substring(left, right + 1));
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
