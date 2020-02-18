package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/implement-strstr/1
 * 
 * Your task is to implement the function strstr. The function takes two strings
 * as arguments (s,x) and locates the occurrence of the string x in the string
 * s. The function returns and integer denoting the first occurrence of the
 * string x in s.
 * 
 * Input Format: The first line of input contains an integer T denoting the no
 * of test cases . Then T test cases follow. The first line of each test case
 * contains two strings s and x.
 * 
 * Output Format: For each test case, in a new line, output will be an integer
 * denoting the first occurrence of the x in the string s. Return -1 if no match
 * found.
 * 
 * Your Task: Since this is a function problem, you don't have to take any
 * input. Just complete the strstr() function. The function returns -1 if no
 * match if found else it returns an integer denoting the first occurrence of
 * the x in the string s.
 * 
 * Constraints: 1 <= T <= 200 1<= |s|,|x| <= 1000
 * 
 * Example: Input 2 GeeksForGeeks Fr GeeksForGeeks For Output -1 5
 * 
 * @author Govind
 *
 */
public class ImplementStrstr {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] strs = br.readLine().trim().split(" ");
			int begin = 0;
			boolean found = false;
			while (true) {
				int start = strs[0].indexOf(strs[1].charAt(0), begin);
				if (start == -1)
					break;
				int end = start + strs[1].length();
				if (end > strs[0].length())
					break;
				String subString = strs[0].substring(start, end);
				if (subString.equals(strs[1])) {
					found = true;
					output.append(start + "\n");
					break;
				} else {
					begin = start + 1;
				}
			}
			if (!found)
				output.append(-1 + "\n");
		}
		System.out.println(output);
	}
}
