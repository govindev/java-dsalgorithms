package com.challenges.gfg.arrays;

import java.util.Scanner;

//Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
//
//Input:
//The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.
//
//Output: 
//For each testcase, print the sorted array.
//
//Constraints:
//1 <= T <= 500
//1 <= N <= 106
//0 <= Ai <= 2
//
//Example:
//Input :
//2
//5
//0 2 1 2 0
//3
//0 1 0
//
//Output:
//0 0 1 2 2
//0 0 1
//
//Explanation:
//Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.

public class SortArrayOf012s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] a = new int[sc.nextInt()];
			int last0Index = -1, last1Index = -1, last2Index = -1;
			for (int j = 0; j < a.length; j++) {
				// Here we can do the counting sort also but I have return a different logic as
				// possible elements are only 3
				int value = sc.nextInt();
				if (value == 0) {
					if (last2Index >= 0) {
						a[last2Index + 1] = 2;
						last2Index++;
					}
					if (last1Index >= 0) {
						a[last1Index + 1] = 1;
						last1Index++;
					}
					a[last0Index + 1] = 0;
					last0Index++;
				} else if (value == 1) {
					if (last2Index >= 0) {
						a[last2Index + 1] = 2;
						last2Index++;
					}
					if (last1Index >= 0) {
						a[last1Index + 1] = 1;
						last1Index++;
					} else {
						a[last0Index + 1] = 1;
						last1Index = last0Index + 1;
					}
				} else {
					a[j] = value;
					last2Index = j;
				}
			}
			for (int j = 0; j < a.length; j++) {
				sb.append(a[j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
