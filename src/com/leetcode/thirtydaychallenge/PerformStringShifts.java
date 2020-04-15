package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/***
 * Perform String Shifts
 * 
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 * 
 * You are given a string s containing lowercase English letters, and a matrix
 * shift, where shift[i] = [direction, amount]:
 * 
 * direction can be 0 (for left shift) or 1 (for right shift). amount is the
 * amount by which string s is to be shifted. A left shift by 1 means remove the
 * first character of s and append it to the end. Similarly, a right shift by 1
 * means remove the last character of s and add it to the beginning. Return the
 * final string after all operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc", shift = [[0,1],[1,2]] Output: "cab" Explanation: [0,1]
 * means shift to left by 1. "abc" -> "bca" [1,2] means shift to right by 2.
 * "bca" -> "cab" Example 2:
 * 
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]] Output: "efgabcd"
 * Explanation: [1,1] means shift to right by 1. "abcdefg" -> "gabcdef" [1,1]
 * means shift to right by 1. "gabcdef" -> "fgabcde" [0,2] means shift to left
 * by 2. "fgabcde" -> "abcdefg" [1,3] means shift to right by 3. "abcdefg" ->
 * "efgabcd"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s only contains lower case English letters. 1 <=
 * shift.length <= 100 shift[i].length == 2 0 <= shift[i][0] <= 1 0 <=
 * shift[i][1] <= 100
 * 
 * @author Govind
 *
 */
public class PerformStringShifts {

	public static void main(String[] args) throws IOException, NumberFormatException {
		// Reading the string
		System.out.println("Enter the String : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine().trim();
		// Reading the two dimentional array
		System.out.println("Enter the size of the two dimentional array : ");
		Integer size = Integer.parseInt(br.readLine().trim());
		System.out.println("Enter the two dimentional array elements seperated by comma : ");
		// Enter all the elements now
		int[][] shift = new int[size][2];
		String[] shiftMatrixValues = br.readLine().trim().split(",");
		for (int i = 0; i < size; i++) {
			int[] matrix = new int[2];
			matrix[0] = Integer.parseInt(shiftMatrixValues[2 * i + 0]);
			matrix[1] = Integer.parseInt(shiftMatrixValues[2 * i + 1]);
			shift[i] = matrix;
		}
		System.out.println("After performing the shifts, String value is : " + stringShift(string, shift));
	}

	private static String stringShift(String s, int[][] shift) {
		for (int i = 0; i < shift.length; i++) {
			int[] matrix = shift[i];
			int direction = matrix[0];
			int amount = matrix[1];
			if (direction == 0) {
				// Left shift
				s = s.substring(amount, s.length()) + s.substring(0, amount);
			} else {
				// Right shift
				s = s.substring(s.length() - amount, s.length()) + s.substring(0, s.length() - amount);
			}
		}
		return s;
	}
}
