package com.challenges.gfg.string;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
 * https://www.rapidtables.com/math/symbols/roman_numerals.html Given an string
 * in roman no format (s) your task is to convert it to integer .
 * 
 * Input: The first line of each test case contains the no of test cases T. Then
 * T test cases follow. Each test case contains a string s denoting the roman
 * no.
 * 
 * Output: For each test case in a new line print the integer representation of
 * roman number s.
 * 
 * Constraints: 1<=T<=100 1<=roman no range<4000
 * 
 * Example: Input 2 V III Output 5 3
 * 
 * @author Govind
 *
 */

public class RomanNumberToInteger {
	private static int getValue(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String rStr = br.readLine().trim();
			int rVal = 0, prevJVal = 0;
			for (int j = rStr.length() - 1; j >= 0; j--) {
				int jVal = getValue(rStr.charAt(j));
				rVal = (jVal < prevJVal) ? rVal - jVal : rVal + jVal;
				prevJVal = jVal;
			}
			sb.append(rVal + "\n");
		}
		System.out.println(sb);
	}
}
