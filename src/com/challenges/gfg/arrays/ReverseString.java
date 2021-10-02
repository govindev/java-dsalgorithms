package com.challenges.gfg.arrays;

public class ReverseString {
	public void reverseString(char[] s) {
		int mid = s.length / 2;
		for (int i = 0; i < mid; i++) {
			char left = s[i];
			char right = s[s.length - i - 1];
			s[i] = right;
			s[s.length - i - 1] = left;
		}
	}
}
