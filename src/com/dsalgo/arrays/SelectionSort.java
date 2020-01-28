package com.dsalgo.arrays;

public class SelectionSort {

	/***
	 * Select the lowest element in each iteration and swap that to the start
	 * @param array
	 * @return
	 */
	private static int[] sort(int array[]) {
		for (int j = 0; j < array.length - 1; j++) {
			int smallestElementIndex = j;
			for (int i = j + 1; i < array.length; i++) {
				if (array[i] < array[smallestElementIndex]) {
					smallestElementIndex = i;
				}
			}	
			int temp = array[j];
			array[j] = array[smallestElementIndex];
			array[smallestElementIndex] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int unsortedArray[] = { 10, 8, 7, 6, 2 };
		System.out.println("Element of unsorted array : ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(" " + unsortedArray[i]);
		}

		int sortedArray[] = sort(unsortedArray);
		System.out.println("\n Element of sorted array : ");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(" " + sortedArray[i]);
		}
	}

}

// 10 8 7 6

// 10 8 7 6, s = 1 

// 10 8 7 6, s = 2 

// 10 8 7 6, s = 3