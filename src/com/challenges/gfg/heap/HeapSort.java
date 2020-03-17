package com.challenges.gfg.heap;

import java.util.*;

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
				// Find the root
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

					if (parent == 0)
						break;
					current = parent;
				}
			}

		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap 1 9 3 7 7 
	void heapify(int arr[], int n, int i) {
		int currentIndex = 0;
		while (true) {
			int current = arr[currentIndex];
			int leftIndex = (2 * currentIndex) + 1;
			int rightIndex = (2 * currentIndex) + 2;
			if (leftIndex >= n || rightIndex >= n || leftIndex == i)
				break;
			int left = arr[leftIndex];
			int right = arr[rightIndex];
			if (rightIndex == i && arr[currentIndex] > left)
				break;
			if (arr[currentIndex] > left && arr[currentIndex] > right)
				break;
			if (rightIndex == i || left > right) {
				// Exchange current with left
				arr[currentIndex] = left;
				arr[leftIndex] = current;
				currentIndex = leftIndex;
			} else {
				// Exchange current with right
				arr[currentIndex] = right;
				arr[rightIndex] = current;
				currentIndex = rightIndex;
			}
		}
	}
}
