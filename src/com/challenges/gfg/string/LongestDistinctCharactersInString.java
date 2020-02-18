package com.challenges.gfg.string;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
 * 
 * Given a string S, find length of the longest substring with all distinct
 * characters. For example, for input "abca", the output is 3 as "abc" is the
 * longest substring with all distinct characters.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The first line of each test case is String str.
 * 
 * Output: Print length of smallest substring with maximum number of distinct
 * characters. Note: The output substring should have all distinct characters.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ size of str ≤ 10000
 * 
 * Example: Input: 2 abababcdefababcdab geeksforgeeks
 * 
 * Output: 6 7
 * 
 * @author Govind
 *
 */
public class LongestDistinctCharactersInString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int start = 0;
			int max = 1;
			int currentMax = 1;
			for (int s = 1; s < str.length(); s++) {
				for (int p = s - 1; p >= start; p--) {
					if (str.charAt(s) == str.charAt(p)) {
						start = p + 1;
						currentMax = s - p - 1;
						break;
					}
				}
				currentMax++;
				max = (currentMax > max) ? currentMax : max;
			}
			output.append(max + "\n");
		}
		System.out.println(output);
	}
}
