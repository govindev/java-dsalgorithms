package com.dsalgo.recursion;

public class MergeSort {
	// Merge sort algorithm

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

	private static int[] merge(int[] array1, int[] array2) {

		int[] array3 = new int[array1.length + array2.length];

		for (int k = 0, i = 0, j = 0; k < array3.length; k++) {
			if ((j >= array2.length) || (i < array1.length && array1[i] <= array2[j])) {
				array3[k] = array1[i];
				i++;
			} else {
				array3[k] = array2[j];
				j++;
			}
		}

		return array3;
	}

	private static int[] mergeSort(int start, int end, int[] array) {
		if (start < end && start < array.length && end < array.length && (end - start >= 1)) {
			if ((end - start) == 1) {
				//  If  only two elements are there
				int[] array1 = { array[start] };
				int[] array2 = { array[end] };
				return merge(array1, array2);
			} else {
				int mid = (int) (start + end) / 2;
				int[] array1 = mergeSort(start, mid - 1, array);

				int[] array2 = mergeSort(mid, end, array);
				return merge(array1, array2);
			}

		} else {
			// If only single element is there, we don't need to sort it; we can just simply return  it
			int[] array3 = { array[start] };
			return array3;
		}

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
