package com.challenges.gfg.arrays;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 * 
 * Given an array of distinct integers. The task is to count all the triplets
 * such that sum of two elements equals the third element.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. Each test case consists of two lines.
 * First line of each test case contains an Integer N denoting size of array and
 * the second line contains N space separated elements.
 * 
 * Output: For each test case, print the count of all triplets, in new line. If
 * no such triplets can form, print "-1".
 * 
 * Constraints: 1 <= T <= 100 3 <= N <= 105 1 <= A[i] <= 106
 * 
 * Example: Input: 2 4 1 5 3 2 3 3 2 7 Output: 2 -1
 * 
 * Explanation: Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5
 * 
 * @author Govind
 *
 */
public class CountTheTriplets {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int p = 0; p < t; p++) {
			int n = Integer.parseInt(br.readLine());
			String[] aStr = br.readLine().trim().split(" ");
			int[] a = new int[aStr.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(aStr[i]);
			}
			Arrays.sort(a);
			int tripletsCount = 0;
			for (int i = 0; i < n - 1; i++) {
				int iVal = a[i];
				for (int j = i + 1; j < n; j++) {
					int sum = iVal + a[j];
					for (int k = j + 1; k < n; k++) {
						if (sum == a[k]) {
							tripletsCount++;
						}
						if (sum < a[k])
							break;
					}
				}
			}
			tripletsCount = (tripletsCount <= 0) ? -1 : tripletsCount;
			output.append(tripletsCount + "\n");
		}
		System.out.println(output);
	}
}
