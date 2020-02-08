package com.challenges.gfg.arrays;

public class MinimumPlatforms {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int val = a[i];
			for (int j = i - 1; j >= 0; j--) {
				if (val > a[j]) {
					break;
				}
				a[j + 1] = a[j];
				a[j] = val;
			}
		}

		return a;
	}

	private static int[] shellSort(int[] a) {
		// 1. Find the highest gap
		int gap = 0;
		while ((3 * gap + 1) < a.length)
			gap = 3 * gap + 1;

		// 2. Insertion sort
		for (int g = gap; g >= 1; g--)
			for (int i = g; i < a.length; i = i + g) {
				int val = a[i];
				for (int j = i - g; j >= 0; j = j - g) {
					if (val > a[j]) {
						break;
					}
					a[j + g] = a[j];
					a[j] = val;
				}
			}

		return a;
	}

	private static int[] shellSortTwoArrays(int[] a, int[] b) {
		// 1. Find the highest gap
		int gap = 0;
		while ((3 * gap + 1) < a.length)
			gap = 3 * gap + 1;

		// 2. Insertion sort
		for (int g = gap; g >= 1; g--)
			for (int i = g; i < a.length; i = i + g) {
				int val = a[i];
				int bVal = b[i];
				for (int j = i - g; j >= 0; j = j - g) {
					if (val > a[j]) {
						break;
					}
					a[j + g] = a[j];
					a[j] = val;

					b[j + g] = b[j];
					b[j] = bVal;
				}
			}

		return a;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 1, 5, 7, 3 };
		System.out.println("Unsorted array elements are : ");
		print(unsortedArray);

		int[] sortedArray = shellSort(unsortedArray);
		System.out.println("\nSorted Array elements are : ");
		print(sortedArray);
	}

}
