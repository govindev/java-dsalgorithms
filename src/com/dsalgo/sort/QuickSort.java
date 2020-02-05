package com.dsalgo.sort;

public class QuickSort {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}

	private static int partition(int[] array, int start, int end) {
		int i = start;
		int pivot = array[end];
		for (int j = i; j < end; j++) {
			if (array[j] <= pivot) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i = i + 1;
			}
		}
		array[end] = array[i];
		array[i] = pivot;
		return i;
	}

	private static int[] quickSort(int[] array) {
		return quickSort(array, 0, array.length - 1);
	}

	private static int[] quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot, end);
		}
		return array;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 98, 29, 19, 69, 23, 26, 28, 90 };
		System.out.println("Unsorted Array : ");
		print(unsortedArray);

		int[] sortedArray = quickSort(unsortedArray);
		System.out.println("\nSorted Array : ");
		print(sortedArray);
	}
}
