package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/rearrange-characters/0
 * 
 * Given a string S with repeated characters (only lowercase). The task is to
 * rearrange characters in a string such that no two adjacent characters are
 * same.
 * 
 * Note : It may be assumed that the string has only lowercase English
 * alphabets.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. Each test case contains a single line
 * containing a string of lowercase english alphabets.
 * 
 * Output: For each test case in a new line print "1" (without quotes) if the
 * generated string doesn't contains any same adjacent characters, else if no
 * such string is possible to be made print "0" (without quotes).
 * 
 * Constraints: 1 <= T <= 100 1 <= length of string <= 104
 * 
 * Example: Input: 3 geeksforgeeks bbbabaaacd bbbbb
 * 
 * Output: 1 1 0
 * 
 * Explanation: Testcase 1: All the repeated characters of the given string can
 * be rearranged so that no adjacent characters in the string is equal. Testcase
 * 3: Repeated characters in the string cannot be rearranged such that there
 * should not be any adjacent repeated character.
 * 
 * @author Govind
 *
 */
public class RearrangeCharacters {
	public static void main(String[] args) throws IOException, NumberFormatException {
		StringBuilder output = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			StringBuilder temp = new StringBuilder();
			StringBuilder actual = new StringBuilder();
			actual.append(str.charAt(0));
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) == actual.charAt(actual.length() - 1)) {
					temp.append(str.charAt(j));
				} else {
					actual.append(str.charAt(j));
					while (true)
						if (temp.length() > 0 && temp.charAt(0) != actual.charAt(actual.length() - 1)) {
							// remove first character from temp and add it to the last of the actual
							actual.append(temp.charAt(0));
							temp.replace(0, 1, "");
						} else {
							break;
						}
				}
			}
			if (temp.length() == 0) {
				output.append("1\n");
			} else {
				while (temp.length() > 0) {
					int prevLength = temp.length();
					for (int q = 0; q < actual.length() - 2; q++) {
						if (q == 0) {
							if (actual.charAt(0) != temp.charAt(0)) {
								actual = new StringBuilder(temp.charAt(0) + actual.toString());
								temp.replace(0, 1, "");
								break;
							}
						} else {
							if (actual.charAt(q) != temp.charAt(0) && actual.charAt(q + 1) != temp.charAt(0)) {
								actual = new StringBuilder(
										actual.substring(0, q + 1) + temp.charAt(0) + actual.substring(q + 1));
								temp.replace(0, 1, "");
								break;
							}
						}
					}
					if (temp.length() == prevLength)
						break;
				}
				if (temp.length() == 0)
					output.append("1\n");
				else
					output.append("0\n");
			}
		}
		System.out.println(output);
	}
}