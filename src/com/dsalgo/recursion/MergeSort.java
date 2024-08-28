package com.dsalgo.recursion;

public class MergeSort {
	// Merge sort algorithm

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

	private static int[] merge(int low, int mid, int high, int[] array) {
		int[] temp = new int[array.length];
		int left = low, right = mid+1, i = 0;
		while (left < mid+1 && right <= high) {
			if (array[left] <= array[right]) {
				temp[i++] = array[left++];
			} else {
				temp[i++] = array[right++];
			}
		}
		while (left < mid+1) {
			temp[i++] = array[left++];
		}
		while (right <= high) {
			temp[i++] = array[right++];
		}
		i = 0;
		while (low <= high) {
			array[low++] = temp[i++];
		}
		return array;
	}
	public static int[] mergeSort(int low, int high, int[] array) {
		if (low >= high) return array;
		int mid = (low+high)/2;
		mergeSort(low, mid, array);
		mergeSort(mid+1, high, array);
		return merge(low, mid, high, array);
	}

	public static void main(String[] args) {
		// 1. Define the array of elements
		int[] unsortedArray = { 8, 10, 7, 5, 2, 83, 1, 23, 59 };

		System.out.println("Unsorted array elements : ");
		print(unsortedArray);

		System.out.println("\nSorted array elements : ");
		print(mergeSort(0, unsortedArray.length - 1, unsortedArray));
	}

}


// Time Complexity
// Level 1 : 1 array
// Level 2 : 2 arrays
// Level 3 : 4  arrays
// Level h : : 2^(h-1) arrays
// 2^(h-1) = n
// h = 1 + log n
//			  2
// O(n log n)
//        2


// Merge is used by most of the collections classes internally
// Merge is a good algorithm in terms of time complexity; good for large sets of data, not so good for small set of elements
