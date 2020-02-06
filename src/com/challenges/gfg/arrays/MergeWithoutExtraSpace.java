package com.challenges.gfg.arrays;

import java.util.Scanner;

//Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
//
//Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.
//
//Input: arr1[] = {10};
//       arr2[] = {2, 3};
//Output: arr1[] = {2}
//        arr2[] = {3, 10}  
//
//Input: arr1[] = {1, 5, 9, 10, 15, 20};
//       arr2[] = {2, 3, 8, 13};
//Output: arr1[] = {1, 2, 3, 5, 8, 9}
//        arr2[] = {10, 13, 15, 20} 
//Input:
//First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.
//
//Output:
//For each test case, print (X + Y) space separated integer representing the merged array.
//
//Constraints:
//1 <= T <= 100
//1 <= X, Y <= 5*104
//0 <= arr1i, arr2i <= 109
//
//Example:
//Input:
//2
//4 5
//1 3 5 7
//0 2 6 8 9
//2 3
//10 12
//5 18 20
//
//Output:
//0 1 2 3 5 6 7 8 9
//5 10 12 18 20
//
//Explanation:
//Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.

public class MergeWithoutExtraSpace {
	private static StringBuffer arrayStr = new StringBuffer();

	private static void setArrayStr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			arrayStr.append(array[i] + " ");
		}
		arrayStr.append("\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a[] = new int[x + y];
			for (int j = 0; j < x; j++) {
				a[j] = sc.nextInt();
			}
			for (int k = 0; k < y; k++) {
				int value = sc.nextInt();
				a[x + k] = value;
				// Do the insertion sort here
				for (int j = x + k - 1; j >= 0; j--) {
					if (value < a[j]) {
						a[j + 1] = a[j];
						a[j] = value;
					} else {
						break;
					}
				}
			}
			setArrayStr(a);
		}
		System.out.println(arrayStr);
	}

}
