package com.challenges.leetcode.twentyone.feb;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * Valid Anagram
 * 
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3636/
 * 
 * @author Govind
 *
 */
public class IsAnagram {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		String t = br.readLine().trim();
		System.out.println(isAnagram(s, t));
	}

	private static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.equals(t))
			return true;
		int len = t.length();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(0);
			s = s.replaceFirst(ch + "", "");
			t = t.replaceFirst(ch + "", "");
			if (s.length() != t.length())
				return false;
			if (s.equals(t))
				return true;
		}
		return false;
	}
}
