package com.challenges.gfg.string;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 * Input:
 * The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
 * Output:
 * For each test case, in a new line, output a single line containing the reversed String.
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S| <= 2000
 * Example:
 * Input:
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 * Output:
 * much.very.program.this.like.i
 * mno.pqr
 * 
 * @author Govind
 *
 */
public class ReverseWordsInAGivenString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String[] words = br.readLine().trim().split("\\.");
			for (int j = words.length - 1; j > 0; j--) {
				sb.append(words[j] + ".");
			}
			sb.append(words[0] + "\n");
		}
		System.out.println(sb);
	}
}