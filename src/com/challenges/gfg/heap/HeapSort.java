package com.challenges.gfg.heap;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/heap-sort/1
 * 
 * Given an array of size N. The task is to sort the array elements by
 * completing functions heapify() and buildHeap() which are used to implement
 * Heap Sort.
 * 
 * Input: First line of the input denotes number of test cases T. First line of
 * the test case is the size of array and second line consists of array
 * elements.
 * 
 * Output: Sorted array in ascending order.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 106 1 <= arr[i] <= 106
 * 
 * Example: Input: 2 5 4 1 3 9 7 10 10 9 8 7 6 5 4 3 2 1
 * 
 * Output: 1 3 4 7 9 1 2 3 4 5 6 7 8 9 10
 * 
 * Explanation: Testcase 1: After sorting elements using heap sort, elements
 * will be in order as 1, 3, 4, 7 and 9.
 * 
 * @author Govind
 *
 */
class HeapSort {
	void printArray(int arr[], int n) {
		// int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HeapSort hs = new HeapSort();
		int arr[] = new int[1000000];
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			hs.heapSort(arr, n);
			hs.printArray(arr, n);
			T--;
		}
	}

	public void heapSort(int arr[], int n) {
		GfG g = new GfG();
		g.buildHeap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			g.heapify(arr, i, 0);
		}
	}
}

//} Driver Code Ends
class GfG {
	void buildHeap(int arr[], int n) {
		for (int i = 1; i < n; i++) {
			int current = i;
			while (true) {
				// Fix the heap
				// Find the parent
				int parent = 0;
				if (current % 2 == 0) {
					parent = (current / 2) - 1;
				} else {
					parent = (current - 1) / 2;
				}
				if (arr[current] < arr[parent])
					break;
				else {
					int temp = arr[parent];
					arr[parent] = arr[current];
					arr[current] = temp;

					// NOTE : Having (parent == 0) didn't work. Time complexity error is coming
					if (parent <= 0)
						break;
					current = parent;
				}
			}
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap 1 9 3 7 7
	void heapify(int arr[], int n, int i) {
		if (n == 0 || i >= n)
			return;
		int current = arr[i];
		int leftIndex = (2 * i) + 1;
		int rightIndex = (2 * i) + 2;
		if (leftIndex >= n)
			return;
		int left = arr[leftIndex];
		int right = arr[rightIndex];
		if (rightIndex == n) {
			if (current > left)
				return;
			else {
				// Exchange current with left
				arr[i] = left;
				arr[leftIndex] = current;
				return;
			}
		}
		if (current > left && current > right)
			return;
		if (left > right) {
			// Exchange current with left
			arr[i] = left;
			arr[leftIndex] = current;
			heapify(arr, n, leftIndex);
		} else {
			// Exchange current with right
			arr[i] = right;
			arr[rightIndex] = current;
			heapify(arr, n, rightIndex);
		}
	}
}
