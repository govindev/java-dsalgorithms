package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting the number of packets. Then next line contains N space separated values of the array A denoting the values of each packet. The third line of each test case contains an integer m denoting the no of students.

Output:
For each test case in a new line print the minimum difference.

Constraints:
1 <= T <= 100
1 <=N<= 107
1 <= Ai <= 1018
1 <= M <= N

Example:
Input:
2
8
3 4 1 9 56 7 9 12
5
7
7 3 2 4 9 12 56
3

Output:
6
2

Explanation:
Testcase 1: The minimum difference between maximum chocolates and minimum chocolates is 9-3=6*/

public class ChocolateDistributionProblem {

	private static String[] quickSort(int start, int end, String[] arr) {
		if (start >= end) {
			return arr;
		}
		int i = start, j = start;
		int pivot = end;
		int pivotVal = Integer.parseInt(arr[pivot]);
		for (; j < pivot; j++) {
			int jVal = Integer.parseInt(arr[j]);
			if (jVal < pivotVal) {
				// Exchange array values at index i and j
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				// Move i to the right
				i++;
			}
		}
		// Exchange array values at index i and pivot
		String temp = arr[pivot];
		arr[pivot] = arr[i];
		arr[i] = temp;

		// Quick Sort the left part and the right part of the pivot in the array
		quickSort(start, (i == pivot) ? i - 1 : i, arr);
		quickSort(i + 1, end, arr);
		return arr;
	}

	private static String[] quickSort(String[] arr) {
		return quickSort(0, arr.length - 1, arr);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] array = br.readLine().split(" ");
			array = quickSort(array);
			int noOfStudents = Integer.parseInt(br.readLine());
			int minDiff = Integer.parseInt(array[0 + noOfStudents - 1]) - Integer.parseInt(array[0]);;

			for (int p = 1; p < array.length; p++) {
				if (p + noOfStudents > array.length)
					break;
				if ((Integer.parseInt(array[p + noOfStudents - 1]) - Integer.parseInt(array[p])) < minDiff) {
					minDiff = Integer.parseInt(array[p + noOfStudents - 1]) - Integer.parseInt(array[p]);
				}
			}
			sb.append(minDiff + "\n");
		}
		System.out.println(sb);
	}
}
