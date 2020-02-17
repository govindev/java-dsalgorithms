package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/anagram/0
 * 
 * Given two strings a and b consisting of lowercase characters. The task is to
 * check whether two given strings are anagram of each other or not. An anagram
 * of a string is another string that contains same characters, only the order
 * of characters can be different. For example, “act” and “tac” are anagram of
 * each other.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Each test case consist of two strings in 'lowercase' only, in a
 * single line.
 * 
 * Output: Print "YES" without quotes if the two strings are anagram else print
 * "NO".
 * 
 * Constraints: 1 ≤ T ≤ 300 1 ≤ |s| ≤ 1016
 * 
 * Example: Input: 2 geeksforgeeks forgeeksgeeks allergy allergic
 * 
 * Output: YES NO
 * 
 * Explanation: Testcase 1: Both the string have same characters with same
 * frequency. So, both are anagrams. Testcase 2: Characters in both the strings
 * are not same, so they are not anagrams.
 * 
 * @author Govind
 *
 */
public class Anagram {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] strings = br.readLine().trim().split(" ");
			if (strings[0].length() != strings[1].length()) {
				output.append("NO" + "\n");
				continue;
			}
			StringBuilder str2 = new StringBuilder(strings[1]);
			boolean isAnagram = true;
			for (int k = 0; k < strings[0].length(); k++) {
				boolean charFound = false;
				for (int p = 0; p < str2.length(); p++) {
					if (strings[0].charAt(k) == str2.charAt(p)) {
						str2.deleteCharAt(p);
						charFound = true;
						break;
					}
				}
				if (!charFound) {
					isAnagram = false;
					output.append("NO" + "\n");
					break;
				}
			}
			if (isAnagram)
				output.append("YES" + "\n");

		}
		System.out.println(output);
	}
}
