package com.challenges.gfg.arrays;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
	https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
		
	Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array should be in form a < b > c < d > e < f. The relative order of elements is same in the output i.e you have to iterate on the original array only.
	
	Input:
	The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains a single integer N denoting the size of array.
	The second line contains N space-separated integers denoting the elements of the array.
	
	Output:
	For each testcase, print the array in Zig-Zag fashion.
	
	Constraints:
	1 <= T <= 100
	1 <= N <= 100
	0 <= Ai <= 10000
	
	Example:
	Input:
	2
	7
	4 3 7 8 6 2 1
	4
	1 4 3 2
	Output:
	3 7 4 8 2 6 1
	1 4 2 3
*/

public class ZigZagFashion {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] array = br.readLine().trim().replace(" +", " ").split(" ");
			boolean lessThan = true;
			for (int j = 0; j < length - 1; j++) {
				if (lessThan) {
					if (Integer.parseInt(array[j]) < Integer.parseInt(array[j + 1])) {
						sb.append(array[j] + " ");
					} else {
						// Swap
						String temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						sb.append(temp + " ");
					}
					lessThan = false;
				} else {
					if (Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
						sb.append(array[j] + " ");
					} else {
						// Swap
						String temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						sb.append(temp + " ");
					}
					lessThan = true;
				}
			}
			sb.append(array[length - 1] + "\n");
		}
		System.out.println(sb);
	}
}
