package com.challenges.gfg.string;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0#ExpectOP
 * 
 * Given two strings a and b. The task is to find if a string 'a' can be
 * obtained by rotating another string 'b' by 2 places.
 * 
 * Input: The first line of input contains an integer T denoting the no of test
 * cases. Then T test cases follow. In the next two line are two string a and b.
 * 
 * Output: For each test case in a new line print 1 if the string 'a' can be
 * obtained by rotating string 'b' by two places else print 0.
 * 
 * Constraints: 1 <= T <= 50 1 <= length of a, b < 100
 * 
 * Example: Input: 2 amazon azonam geeksforgeeks geeksgeeksfor
 * 
 * Output: 1 0
 * 
 * Explanation: Testcase 1: amazon can be rotated anti-clockwise by two places,
 * which will make it as azonam.
 * 
 * Testcase 2: geeksgeeksfor can't be formed by any rotation from the given word
 * geeksforgeeks.
 * 
 * @author Govind
 *
 */
class CheckIfStringIsRotatedByTwoPlaces {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder total = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String str = br.readLine().trim();
			String reverse = br.readLine().trim();
			StringBuilder sb = new StringBuilder();
			sb.append(str.substring(2, str.length()));
			sb.append(str.substring(0, 2));
			if (reverse.equals(sb.toString())) {
				total.append(1 + "\n");
				continue;
			}
			StringBuilder sb2 = new StringBuilder();
			sb2.append(str.substring(str.length() - 2, str.length()));
			sb2.append(str.substring(0, str.length() - 2));
			if (reverse.equals(sb2.toString())) {
				total.append(1 + "\n");
				continue;
			}
			total.append(0 + "\n");
		}
		System.out.println(total);
	}
}