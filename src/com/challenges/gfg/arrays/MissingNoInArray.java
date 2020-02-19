
package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;;

/**
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
 * 
 * Given an array C of size N-1 and given that there are numbers from 1 to N
 * with one element missing, the missing number is to be found.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. For each test case first line contains N(size of array). The
 * subsequent line contains N-1 array elements.
 * 
 * Output: Print the missing number in array.
 * 
 * Constraints: 1 ≤ T ≤ 200 1 ≤ N ≤ 107 1 ≤ C[i] ≤ 107
 * 
 * Example: Input: 2 5 1 2 3 5 10 1 2 3 4 5 6 7 8 10
 * 
 * Output: 4 9
 * 
 * Explanation: Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 * 
 * @author Govind
 *
 */

public class MissingNoInArray {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] aStr = br.readLine().trim().split(" ");
			int[] a = new int[aStr.length];
			for (int s = 0; s < aStr.length; s++) {
				a[s] = Integer.parseInt(aStr[s]);
			}
			Arrays.sort(a);
			boolean noFound = false;
			if (a[0] != 1) {
				output.append(1 + "\n");
				continue;
			}
			for (int j = 1; j < aStr.length; j++) {
				if (a[j] != j + 1) {
					output.append(j + 1 + "\n");
					noFound = true;
					break;
				}
			}
			if (noFound)
				continue;
			output.append(length + "\n");
		}
		System.out.println(output);
	}

}
