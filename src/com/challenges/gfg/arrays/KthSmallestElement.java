package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
//
//Expected Time Complexity: O(n)
//
//Input:
//The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
//
//Output:
//Corresponding to each test case, print the kth smallest element in a new line.
//
//Constraints:
//1 <= T <= 100
//1 <= N <= 105
//1 <= arr[i] <= 105
//1 <= K <= N
//
//Example:
//Input:
//2
//6
//7 10 4 3 20 15
//3
//5
//7 10 4 20 15
//4
//
//Output:
//7
//15
//
//Explanation:
//Testcase 1: 3rd smallest element in the given array is 7.

public class KthSmallestElement {
	private static String[] arr;

	private static void quickSort(int from, int to) {
		if (to - from < 1) {
			return;
		}
		int pivot = to, i = from, j = from;
		for (; j < pivot; j++) {
			if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[pivot])) {
				if (i != j) {
					String temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				i++;
			}
		}
		// i is the new pivot
		if (pivot != i) {
			String temp = arr[pivot];
			arr[pivot] = arr[i];
			arr[i] = temp;
			quickSort(from, i);
			quickSort(i, to);
		} else {
			quickSort(from, i - 1);
		}
	}

	private static void quickSort() {
		quickSort(0, arr.length - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			br.readLine();
			arr = br.readLine().split(" ");
			quickSort();
			sb.append(arr[Integer.parseInt(br.readLine()) - 1] + "\n");
		}
		System.out.println(sb);
	}

}