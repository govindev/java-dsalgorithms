package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/form-a-palindrome/0
 * 
 * Given a string, find the minimum number of characters to be inserted to
 * convert it to palindrome. For Example: ab: Number of insertions required is
 * 1. bab or aba aa: Number of insertions required is 0. aa abcd: Number of
 * insertions required is 3. dcbabcd
 * 
 * Input:
 * 
 * The first line of input contains an integer T denoting the number of test
 * cases. The first line of each test case is S.
 * 
 * Output:
 * 
 * Print the minimum number of characters.
 * 
 * Constraints:
 * 
 * 1 ≤ T ≤ 50 1 ≤ S ≤ 40
 * 
 * Example:
 * 
 * Input: 3 abcd aba geeks
 * 
 * Output: 3 0 3
 * 
 * @author Govind
 *
 */
public class FormAPalindrome {
	private static boolean isPalindrome(String str, int start, int end) {
		for (int i = start, j = end; i <= end; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	private static int noOfInsertsForPalindrome(String str, int pStart, int pEnd) {
		int leftCount = pStart - 0;
		int rightCount = str.length() - pEnd - 1;
		int count = 0;
		while (leftCount != 0 || rightCount != 0) {
			if (pStart == 0) {
				count += rightCount;
				break;
			} else if (pEnd == str.length() - 1) {
				count += leftCount;
				break;
			}
			if (str.charAt(pStart - 1) != str.charAt(pEnd + 1)) {
				count++;
				if (leftCount <= rightCount) {
					rightCount--;
					str = new StringBuilder().append(str.substring(0, pStart)).append(str.charAt(pEnd + 1))
							.append(str.substring(pStart, str.length())).toString();
					pEnd = pEnd + 2;
				} else {
					leftCount--;
					str = new StringBuilder().append(str.substring(0, pEnd + 1)).append(str.charAt(pStart - 1))
							.append(str.substring(pEnd + 1, str.length())).toString();
					pStart--;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			boolean brk = false;
			for (int j = str.length() - 1; j >= 0; j--) {
				if (brk)
					break;
				if (j == 0) {
					// Find the mid and start forming the palindrome from the mid
					int mid = (str.length()) / 2;
					output.append(noOfInsertsForPalindrome(str, mid, mid) + "\n");
				} else
					for (int sStart = 0; (sStart + j) <= str.length() - 1; sStart++) {
						if (isPalindrome(str, sStart, sStart + j)) {
							// This portion of the string is a palindrome
							output.append(noOfInsertsForPalindrome(str, sStart, sStart + j) + "\n");
							brk = true;
							break;
						}
					}
			}
		}
		System.out.println(output);
	}
}
