package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Backspace String Compare
 * 
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
 * 
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * 
 * @author Govind
 *
 */

public class BackspaceStringCompare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine().trim();
		String T = br.readLine().trim();
		System.out.println("Backspace Compare : " + backspaceCompare(S, T));
	}

	public static boolean backspaceCompare(String S, String T) {
		S = formatString(S);
		T = formatString(T);
		return S.equals(T);
	}

	public static String formatString(String S) {
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (ch == '#') {
				if (i == 0) {
					S = S.substring(1, S.length());
					i = -1;
				} else {
					S = S.substring(0, i - 1) + S.substring(i + 1, S.length());
					i = i - 2;
				}
			}
		}
		return S;
	}
}
