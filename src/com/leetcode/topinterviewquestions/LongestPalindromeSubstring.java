package com.leetcode.topinterviewquestions;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "cbbd";
		// System.out.println(isPalindrome(s, 0, s.length() - 1));
		System.out.println(longestPalindrome(s));
	}

	private static String longestPalindrome(String s) {
		int longestPalStart = 0, longestPalEnd = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = s.length() - 1; j >= i + 1; j--) {
				System.out.println("i : " + i + " j : " + j);
				
				
				
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
