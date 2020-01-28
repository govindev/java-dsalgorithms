package com.dsalgo.arrays;

public class BubbleSort {

	private static int[] sort(int[] arr) {
		for (int j = 0; j <= arr.length - 2; j++) {
			for (int i = 0; i <= arr.length - 2 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					// Swap the elements
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int unsortedArray[] = { 10, 8, 7, 6, 2 };
		System.out.println("Unsorted Array is : ");
		for (int i = 0; i <= unsortedArray.length - 1; i++) {
			System.out.print(" " + unsortedArray[i]);
		}

		int sortedArray[] = sort(unsortedArray);
		System.out.println("\nSorted Array is : ");
		for (int i = 0; i <= sortedArray.length - 1; i++) {
			System.out.print(" " + sortedArray[i]);
		}
	}

}

// 1st Iteration
//0 1 2 3
//9 8 7 6
//
//0 1 2 3
//8 7 6 9
//
// 2nd Iteration
//0 1 2
//8 7 6
//
//0 1 2
//7 6 8
//
// 3rd Iteration
//0 1
//7 6
//
//0 1
//6 7



// NOTE
// FOR SORTING 5 ELEMENTS
// 1 3, 1 3, 1 3, 1 3 = 4 + 4 * 3 = 16
// 1 3, 1 3, 1 3 = 3 + 3 * 3 = 12
// 1 3, 1 3 = 2 + 2 * 3 = 8 
// 1 3 = 4
// 16 + 12 + 8 + 4 = 4 (4 + 3 + 2 + 1) = 4 (n -1 + n -2 + ....  + 1) = 4 (n)(n-1) / 2 = 2 (n) (n-1) is the worst time complexity