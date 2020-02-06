package com.challenges.gfg.arrays;

import java.util.Scanner;

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//Output:
//Print the maximum sum of the contiguous sub-array in a separate line for each test case.
//
//Constraints:
//1 ≤ T ≤ 110
//1 ≤ N ≤ 106
//-107 ≤ A[i] <= 107
//
//Example:
//Input
//2
//5
//1 2 3 -2 5
//4
//-1 -2 -3 -4
//Output
//9
//-1
//
//Explanation:
//Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

public class KadanesAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
//		if (!(t >= 1 && t <= 110)) {
//			System.out.println("Value should be between 1 and 110. Exiting");
//			return;
//		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
//			if (!(n >= 1 && n <= 1000000)) {
//				System.out.println("Value should be between 1 and 1000000. Exiting");
//				return;
//			}
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
//				if (!(a[j] >= 10000000 && a[j] <= 10000000)) {
//					System.out.println("value should be between -10000000 and 10000000. Exiting");
//					return;
//				}
			}
			int highest = a[0];
			for (int p = 0; p < n - 1; p++) {
				if (a[p] > highest) {
					highest = a[p];
				}
				int sum = a[p];
				for (int q = p + 1; q < n; q++) {
					sum += a[q];
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
