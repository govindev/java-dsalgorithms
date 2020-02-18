package com.challenges.gfg.string;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array/0#ExpectOP
 * 
 * Given a array of N strings, find the longest common prefix among all strings
 * present in the array.
 * 
 * Input: The first line of the input contains an integer T which denotes the
 * number of test cases to follow. Each test case contains an integer N. Next
 * line has space separated N strings.
 * 
 * Output: Print the longest common prefix as a string in the given array. If no
 * such prefix exists print "-1"(without quotes).
 * 
 * Constraints: 1 <= T <= 103 1 <= N <= 103 1 <= |S| <= 103
 * 
 * Example: Input: 2 4 geeksforgeeks geeks geek geezer 3 apple ape april
 * 
 * Output: gee ap
 * 
 * Explanation: Testcase 1: Longest common prefix in all the given string is
 * gee.
 * 
 * @author Govind
 *
 */

public class LongestCommonPrefixInAnArray {
	private static boolean findSubstring(String str, String key) {
		String subStr = str.substring(0, key.length());
		if (subStr.equals(key))
			return true;
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] strs = br.readLine().trim().split(" ");
			// Find the string which is minimum
			int minStrIndex = 0;
			int minStrLen = strs[minStrIndex].length();
			for (int j = 0; j < length; j++) {
				if (minStrLen > strs[j].length()) {
					minStrLen = strs[j].length();
					minStrIndex = j;
				}
			}
			boolean found = true;
			for (int j = minStrLen; j > 0; j--) {
				found = true;
				String findStr = strs[minStrIndex].substring(0, j);
				for (int k = 0; k < length; k++) {
					if (k == minStrIndex)
						continue;
					if (!findSubstring(strs[k], findStr)) {
						found = false;
						break;
					}
				}
				if (found) {
					output.append(findStr + "\n");
					break;
				}
			}
			if (!found)
				output.append(-1 + "\n");
		}
		System.out.println(output);
	}
}
