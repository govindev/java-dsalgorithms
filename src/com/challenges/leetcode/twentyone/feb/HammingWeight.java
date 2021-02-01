package com.challenges.leetcode.twentyone.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3625/
 * 
 * @author Govind
 *
 */

public class HammingWeight {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("n = ");
		Integer num = Integer.parseInt(inp.readLine(), 2);
		System.out.println(hammingWeight(num));
	}

	public static int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((n >> i) & 1) == 1) {
				count++;
			}
		}
		return count;
	}
}
