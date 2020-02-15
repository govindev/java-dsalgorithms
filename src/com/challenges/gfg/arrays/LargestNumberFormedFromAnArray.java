package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
	https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
	Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
	
	Input:
	The first line of input consists number of the test cases. The description of T test cases is as follows:
	The first line of each test case contains the size of the array, and the second line has the elements of the array.
	
	Output:
	In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
	
	Constraints:
	1 ≤ T ≤ 100
	1 ≤ N ≤ 102
	0 ≤ A[i] ≤ 103
	
	Example:
	Input:
	2
	5
	3 30 34 5 9
	4
	54 546 548 60
	
	Output:
	9534330
	6054854654
*/

public class LargestNumberFormedFromAnArray {

	private static boolean compare(String s1, String s2) {
		if ((s1 + s2).compareTo(s2 + s1) > 0)
			return true;
		return false;
	}

	private static String[] quickSort(int start, int end, String[] elements) {
		if (start >= end) {
			return elements;
		}
		int i = start, j = start;
		int pivot = end;
		for (; j < pivot; j++) {

			if (compare(elements[pivot], elements[j])) {
				// J is smaller
				String temp = elements[j];
				elements[j] = elements[i];
				elements[i] = temp;
				i++;
			}
		}
		if (pivot != i) {
			// Exchange pivot and i
			String temp = elements[pivot];
			elements[pivot] = elements[i];
			elements[i] = temp;

			elements = quickSort(start, i, elements);
			elements = quickSort(i, end, elements);
		} else {
			elements = quickSort(start, i - 1, elements);
		}
		return elements;
	}

	private static String[] quickSort(String[] elements) {
		return quickSort(0, elements.length - 1, elements);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().trim().replace(" +", " ").split(" ");
			elements = quickSort(elements);
			for (int j = length - 1; j >= 0; j--) {
				sb.append(elements[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
