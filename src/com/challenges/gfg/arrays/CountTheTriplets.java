package com.challenges.gfg.arrays;

import java.util.Scanner;

//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//Output:
//For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".
//
//Constraints:
//1 <= T <= 100
//3 <= N <= 105
//1 <= A[i] <= 106
//
//Example:
//Input:
//2
//4
//1 5 3 2
//3
//3 2 7
//Output:
//2
//-1
//
//Explanation:
//Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

public class CountTheTriplets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if (!(1 <= t && t <= 100)) {
			System.out.println("Value must be between 1 and 100. Exiting");
			return;
		}
		StringBuffer sb = new StringBuffer("");
		for (int z = 0; z < t; z++) {
			int n = sc.nextInt();
			if (!(3 <= n && n <= 100000)) {
				System.out.println("Value must be between 3 and 105. Exiting");
				return;
			}
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
				if (!(1 <= a[i] && a[i] <= 1000000)) {
					System.out.println("Value must be between 1 and 106. Exiting");
					return;
				}
			}
			int count = 0;
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = i + 1; j < a.length; j++) {
					int sum = a[i] + a[j];
					for (int k = 0; k < a.length; k++) {
						if (sum == a[k]) {
							// Found one
							count++;
						}
					}
				}
			}
			if (count == 0) {
				count = -1;
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
