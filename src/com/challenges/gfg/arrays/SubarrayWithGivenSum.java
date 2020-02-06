package com.challenges.gfg.arrays;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Number of Test cases
		if (!(T >= 1 && T <= 100)) {
			System.out.println("Value is not in range of 1 and 100. Exiting");
			System.exit(0);
		}
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < T; i++) {
			if (i != 0)
				output.append("\n");
			int n = sc.nextInt(); // Number of elements in the array
			if (!(n >= 1 && n <= 10000000)) {
				System.out.println("Size value is not in range of 1 and 107. Exiting");
			}
			int s = sc.nextInt(); // Subarray sum that
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			// Find the sum in the subarray
			boolean sumFound = false;
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = j; k < n; k++) {
					sum = sum + a[k];
					if (sum == s) {
						// Found the subarray
						output.append((j + 1) + " " + (k + 1));
						sumFound = true;
						break;
					}
				}
				if (sumFound) {
					break;
				}
			}
			if (!sumFound) {
				output.append(-1);
			}
		}
		System.out.println(output);
	}

}
