package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/implement-atoi/1
 * 
 * Your task is to implement the function atoi. The function takes a string(str)
 * as argument and converts it to an integer and returns it.
 * 
 * Input: The first line of input contains an integer T denoting the no of test
 * cases . Then T test cases follow. Each test case contains a string str .
 * 
 * Output: For each test case in a new line output will be an integer denoting
 * the converted integer, if the input string is not a numerical string then
 * output will be -1.
 * 
 * Constraints: 1<=T<=100 1<=length of (s,x)<=10
 * 
 * Example(To be used only for expected output) : Input: 2 123 21a
 * 
 * Output: 123 -1
 * 
 * @author Govind
 *
 */
public class ImplementAtoi {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			try {
				int num = Integer.parseInt(br.readLine());
				output.append(num + "\n");
			} catch (NumberFormatException ex) {
				output.append(-1 + "\n");
			}
		}
		System.out.println(output);

		// There are other ways of solving this problem
		// One is to use the regular expression check
		// and the other one is to check each character against the 0 to 9 digits
	}
}
