package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
//
//Output:
//For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
//
//Constraints:
//1 <= T <= 100
//1 <= N <= 107
//1 <= Ai <= 1010
//
//Example:
//Input:
//2
//5 12
//1 2 3 7 5
//10 15
//1 2 3 4 5 6 7 8 9 10
//Output:
//2 4
//1 5
//
//Explanation :
//Testcase1: sum of elements from 2nd position to 4th position is 12
//Testcase2: sum of elements from 1st position to 5th position is 15

public class SubarrayWithGivenSum {

	public static void main(String[] args) throws IOException {
		StringBuilder output = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // Number of Test cases
		for (int i = 0; i < T; i++) {
			String sInp = br.readLine();
			String[] aInp = sInp.split(" ");
			int n = Integer.parseInt(aInp[0]); // Number of elements in the array
			int s = Integer.parseInt(aInp[1]); // Subarray sum that

			sInp = br.readLine();
			aInp = sInp.split(" ");
			// Find the sum in the subarray
			boolean sumFound = false;
			for (int j = 0; j < n; j++) {
				int sum = Integer.parseInt(aInp[j]);
				if (sum > s)
					continue;
				if (sum == s) {
					output.append((j + 1) + " " + (j + 1) + "\n");
					sumFound = true;
					break;
				}
				for (int k = j + 1; k < n; k++) {
					int value = Integer.parseInt(aInp[k]);
					sum = sum + value;
					if (k > s || sum > s)
						break;
					if (k == s) {
						output.append((k + 1) + " " + (k + 1) + "\n");
						sumFound = true;
						break;
					}
					if (sum == s) {
						output.append((j + 1) + " " + (k + 1) + "\n");
						sumFound = true;
						break;
					}
				}
				if (sumFound) {
					break;
				}
			}
			if (!sumFound) {
				output.append(-1 + "\n");
			}
		}
		System.out.println(output);
	}

}
