package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/remove-duplicates/0
 * 
 * Given a string, the task is to remove duplicates from it. Expected time
 * complexity O(n) where n is length of input string and extra space O(1) under
 * the assumption that there are total 256 possible characters in a string.
 * 
 * Note: that original order of characters must be kept same.
 * 
 * Input: First line of the input is the number of test cases T. And first line
 * of test case contains a string.
 * 
 * Output: Modified string without duplicates and same order of characters.
 * 
 * Constraints: 1 <= T <= 15 1 <= |string|<= 1000
 * 
 * Example: Input: 2 geeksforgeeks geeks for geeks
 * 
 * Output: geksfor geks for
 * 
 * @author Govind
 *
 */

public class RemoveDuplicates {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine().trim();
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(0));
			for (int j = 1; j < str.length(); j++) {
				if (sb.toString().indexOf(str.charAt(j)) == -1) {
					sb.append(str.charAt(j));
				}
			}
			output.append(sb + "\n");
		}
		System.out.println(output);
	}
}
