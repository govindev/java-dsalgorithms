package com.dsalgo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ShellSort {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(" " + array[i]);
		}
	}

	private static int[] shellSort(int[] array) {
		// 1. Find out the 'h' value list
		int h = 0;
		List<Integer> hList = new ArrayList<Integer>();
		do {
			hList.add(h);
			h = 3 * h + 1;
		} while (h < array.length);

		// 2. Loop through the hList
		ListIterator<Integer> hIter = hList.listIterator();
		while (hIter.hasNext()) {
			h = hIter.next();

			// 3. Loop through between 0 to h
			for (int k = 0; k < h; k++) {
				// 4. Loop through the array for the insertion sort
				int i = 0 + k + h;
				for (; i < array.length; i = i + h) {
					int newElement = array[i];
					// 5. Insertion sort
					for (int j = i - h; j >= 0; j = j - h) {
						if (newElement < array[j]) {
							array[j + h] = array[j];
							array[j] = newElement;
						} else {
							break;
						}
					}
				}
			}
		}

		return array;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 10, 30, 2, 73, 29, 39 };
		System.out.println("Unsorted Array Elements : ");
		print(unsortedArray);

		int[] sortedArray = shellSort(unsortedArray);
		System.out.println("Sorted Array Elements : ");
		print(sortedArray);
	}

}
