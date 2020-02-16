package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 * Given a string S. The task is to print all permutations of a given string.
 * Input:
 * The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.
 * Output:
 * For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 * Example:
 * Input:
 * 2
 * ABC
 * ABSG
 * Output:
 * ABC ACB BAC BCA CAB CBA 
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 * Explanation:
 * Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA 
 * @author Govind
 *
 */
public class PermutationsOfAGivenString {
	private static StringBuilder totalStr = new StringBuilder();
	private static Set<String> strs;

	private static void findPermutations(String str, int start) {
		if (start < str.length() - 1) {
			char charAtStart = str.charAt(start);
			for (int i = start; i < str.length(); i++) {
				StringBuilder sb = new StringBuilder(str);
				sb.setCharAt(start, str.charAt(i));
				sb.setCharAt(i, charAtStart);
				findPermutations(sb.toString(), start + 1);
				if (start == str.length() - 2)
					strs.add(sb.toString());
			}
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			strs = new TreeSet<String>();
			String str = br.readLine().trim();
			if (str.length() < 2) {
				totalStr.append(str);
			} else {
				findPermutations(str, 0);
				for (String str1 : strs) {
					totalStr.append(str1 + " ");
				}
			}
			totalStr.append("\n");
		}
		System.out.println(totalStr);
	}
}