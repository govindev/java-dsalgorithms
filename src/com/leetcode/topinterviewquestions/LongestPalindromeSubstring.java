package com.leetcode.topinterviewquestions;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "babaddtattarrattatddetartrateedredividerb";
		// System.out.println(isPalindrome(s, 0, s.length() - 1));
		// System.out.println(longestPalindromeBetter3(s));
		// System.out.println(longestPalindromeBetter2(s, 0, s.length() - 1));
		System.out.println(longestPalindromeDP(s));
	}

	private static String longestPalindromeDP(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		int start = 0, end = 0;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int j = i + k;
				if (j >= n)
					break;
				dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
				if (i + 1 <= j - 1 && dp[i][j] == 1) {
					dp[i][j] = dp[i + 1][j - 1];
				}
				if (dp[i][j] == 1 && j - i > end - start) {
					start = i;
					end = j;
				}
			}
		}

		return s.substring(start, end);
	}

	private static String longestPalindromeBetter3(String s) {
		int k = s.length(), left = 0, right = s.length() - 1;
		for (; k >= 1; k--) {
			left = 0;
			right = left + k - 1;
			while (right <= s.length() - 1) {
				if (isPalindrome(s, left, right)) {
					return s.substring(left, right + 1);
				}
				left++;
			}
		}
		return null;
	}

	private static String longestPalindromeBetter2(String s, int left, int right) {
		if (left == right) {
			return s.charAt(left) + "";
		}
		if (left > right) {
			return null;
		}
		if (isPalindrome(s, left, right)) {
			System.out.println("palindrome : " + s.substring(left, right + 1));
			return s.substring(left, right + 1);
		} else {
			String longestPalindrome1 = longestPalindromeBetter2(s, left, right - 1);
			String longestPalindrome2 = longestPalindromeBetter2(s, left + 1, right);
			return longestPalindrome1.length() > longestPalindrome2.length() ? longestPalindrome1 : longestPalindrome2;
		}
	}

	public static String longestPalindromeBetter1(String s) {
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
