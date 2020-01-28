package com.dsalgo.arrays;

public class InsertionSort {
	
	private static void print(String msg, int[] arr) {
		System.out.println("\n" + msg);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	/**
	 * Insertion sort - Visualize deck of cards example
	 * Every time you find a new card, you think of arranging comparing it to the top most card
	 * if the top card value is more you move it to right
	 * Follow it till you find a place where the new card fits
	 * @param array
	 * @return
	 */
	private static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int newLocation = i;
//			for (int j = i - 1; j >= 0; j--) {
//				if (temp < array[j]) {
//					array[newLocation] = array[j];
//					newLocation = j;
//				}
//			}
			int j = i - 1;
			while(j >= 0 && temp < array[j]) {
				array[newLocation] = array[j];
				newLocation = j;
				j--;
			}
					
			array[newLocation] = temp;
			print("Iteration " + i, array);
		}
		return array;
	}
	
	public static void main(String[] args) {
		int unsortedArray[] = {10, 8, 7, 6, 2};
		System.out.println("Unsorted array elements are : ");
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(" " + unsortedArray[i]);
		}
		
		int sortedArray[] = sort(unsortedArray);
		System.out.println("\nSorted Array elements are : ");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(" " + sortedArray[i]);
		}
	}

}
