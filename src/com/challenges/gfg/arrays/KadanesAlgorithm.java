package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0#ExpectOP
 * 
 * Given an array arr of N integers. Find the contiguous sub-array with maximum
 * sum.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The description of T test cases follows. The first line of each
 * test case contains a single integer N denoting the size of array. The second
 * line contains N space-separated integers A1, A2, ..., AN denoting the
 * elements of the array.
 * 
 * Output: Print the maximum sum of the contiguous sub-array in a separate line
 * for each test case.
 * 
 * Constraints: 1 ≤ T ≤ 110 1 ≤ N ≤ 106 -107 ≤ A[i] <= 107
 * 
 * Example: Input 2 5 1 2 3 -2 5 4 -1 -2 -3 -4 Output 9 -1
 * 
 * Explanation: Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5)
 * which is a contiguous subarray.
 * 
 * @author Govind
 *
 */
public class KadanesAlgorithm {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] a = br.readLine().trim().split(" ");
			int highest = Integer.parseInt(a[0]);
			int prevElementsSum = 0;
			for (int p = 0; p < n - 1; p++) {
				int presVal = Integer.parseInt(a[p]);
				if (p > 0 && prevElementsSum > 0) {
					prevElementsSum += presVal;
					continue;
				}
				prevElementsSum += presVal;
				if (presVal > highest) {
					highest = presVal;
				}

				int sum = presVal;
				for (int q = p + 1; q < n; q++) {
					sum += Integer.parseInt(a[q]);
					if (sum <= 0)
						break;
					if (sum > highest) {
						highest = sum;
					}

				}
			}
			sb.append(highest + "\n");
		}
		System.out.println(sb);
	}

}
