package com.dsalgo.sort.linear;

public class CountingSort {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}

	}

	private static int[] countingSort(int[] array) {
		// 1. Find the highest in the array
		int highest = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > highest) {
				highest = array[i];
			}
		}

		// 2. Create a temporary with the size 'highest'
		int[] temp = new int[highest + 1];

		// 3. Loop through the array and for each value increment the value at the index
		// in the temp array
		for (int i = 0; i < array.length; i++) {
			temp[array[i]] = temp[array[i]] + 1;
		}

		// 4. Put back the values in the original array
		for (int i = 0, j = 0; i < temp.length; i++) {
			int rep = temp[i];
			if (rep != 0) {
				for (int k = 0; k < rep; k++) {
					array[j++] = i;
				}
			}
		}

		return array;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 10, 9, 2, 3, 3, 9, 10, 6, 3, 5, 6 };
		System.out.println("Unsorted Array elements are : ");
		print(unsortedArray);
		int[] sortedArray = countingSort(unsortedArray);
		System.out.println("\nSorted Array elements are : ");
		print(sortedArray);
	}

}
