package com.challenges.gfg.arrays;

import java.util.Scanner;

//Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
//
//Input:
//The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.
//
//Output:
//For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.
//
//Constraints:
//1 <= T <= 100
//1 <= N <= 106
//1 <= Ai <= 108
//
//Example:
//Input:
//2
//1
//1
//5
//1 3 5 2 2
//
//Output:
//1
//3
//
//Explanation:
//Testcase 1: Since its the only element hence its the only equilibrium point.
//Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).

public class EquilibriumPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] a = new int[sc.nextInt()];
			for (int j = 0; j < a.length; j++) {
				a[j] = sc.nextInt();
			}
			int equilibriumPoint = -1;
			if (a.length == 1) {
				equilibriumPoint = a[0];
			} else {
				for (int j = 0; j < a.length; j++) {
					int leftSum = 0;
					for (int k = 0; k < j; k++) {
						leftSum += a[k];
					}
					int rightSum = 0;
					for (int l = j + 1; l < a.length; l++) {
						if (rightSum > leftSum)
							break;
						rightSum += a[l];
					}
					if (leftSum == rightSum) {
						equilibriumPoint = j + 1;
						break;
					}
				}
			}
			sb.append(equilibriumPoint + "\n");
		}
		System.out.println(sb);
	}

}
