package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
 * 
 * Given a string s, recursively remove adjacent duplicate characters from the
 * string s. The output string should not have any adjacent duplicates.
 * 
 * 
 * Input: The first line of input contains an integer T, denoting the no of test
 * cases. Then T test cases follow. Each test case contains a string str.
 * 
 * Output: For each test case, print a new line containing the resulting string.
 * 
 * Constraints: 1<=T<=100 1<=Length of string<=50
 * 
 * Example: Input: 2 geeksforgeek acaaabbbacdddd
 * 
 * Output: gksforgk acac
 * 
 * @author Govind
 *
 */

public class RecursivelyRemoveAllAdjucentDuplicates {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine().trim();

			int k = 0;
			StringBuilder sb = new StringBuilder();
			while (k < str.length()) {
				sb.setLength(0);
				sb.append(str.charAt(0));
				for (int j = 1; j < str.length(); j++) {
					if (Character.getNumericValue(str.charAt(j - 1)) != Character.getNumericValue(str.charAt(j))) {
						sb.append(str.charAt(j));
					} else {
						// Remove last character in sb
						if (sb.length() > 0 && Character.getNumericValue(str.charAt(j)) == Character
								.getNumericValue(sb.charAt(sb.length() - 1)))
							sb.deleteCharAt(sb.length() - 1);
					}
				}
				str = sb.toString();
				k++;
			}
			output.append(sb + "\n");
		}
		System.out.println(output);
	}
}