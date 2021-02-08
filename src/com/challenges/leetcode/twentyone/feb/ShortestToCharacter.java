package com.challenges.leetcode.twentyone.feb;

/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/
 * 
 * @author Govind
 *
 */
public class ShortestToCharacter {
	public int[] shortestToChar(String s, char c) {
		int n = s.length();
		int[] output_arr = new int[n];
		int c_position = -n;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c) {
				c_position = i;
			}
			output_arr[i] = i - c_position;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == c) {
				c_position = i;
			}
			output_arr[i] = Math.min(output_arr[i], Math.abs(i - c_position));
		}
		return output_arr;
	}
}
