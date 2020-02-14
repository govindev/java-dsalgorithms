package com.challenges.gfg.arrays;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*	
	https://practice.geeksforgeeks.org/problems/last-index-of-1/0

	Given a string S consisting only '0's and '1's,  print the last index of the '1' present in it.

	Input:
	First line of the input contains the number of test cases T, T lines follow each containing a stream of characters.

	Output:
	Corresponding to every test case, output the last index of 1. If 1 is not present, print "-1" (without quotes).

	Constraints:
	1 <= T <= 110
	1 <= |S| <= 106

	Example:
	Input:
	2
	00001
	0
	Output:
	4
	-1

	Explanation:
	Testcase 1: Last index of  1 in given string is 4.
	Testcase 2: Since, 1 is not present, so output is -1.
*/
public class LastIndexOfOne {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String num = br.readLine();
			int lastIndex = -1;
			for (int j = num.length() - 1; j >= 0; j--) {
				if (Character.getNumericValue(num.charAt(j)) == 1) {
					lastIndex = j;
					break;
				}
			}
			sb.append(lastIndex + "\n");
		}
		System.out.println(sb);
	}
}