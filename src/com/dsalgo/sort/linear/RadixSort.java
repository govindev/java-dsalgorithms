package com.dsalgo.sort.linear;

public class RadixSort {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(" " + array[i]);
		}
	}

	private static int digitAtPosition(int number, int position) {
		int divideBy = 1;
		for (int i = 0; i < position; i++) {
			divideBy = divideBy * 10;
		}
		return number % divideBy;
	}

	private static int[] countingSort(int[] array, int digitIndex) {
		// 1. Find the highest element in the array at the digitIndex position
		int highest = 0;
		for (int i = 0; i < array.length; i++) {
			int digit = digitAtPosition(array[i], digitIndex + 1);
			if (digit > highest) {
				highest = digit;
			}
		}

		// 2. Create an array with the size as the 'highest'
		int[] temp = new int[highest + 1];
				
		// 3. Loop through the array elements and increment the temp array value
		// relative to the index
		for (int i = 0; i < array.length; i++) {
			int digit = digitAtPosition(array[i], digitIndex + 1);
			temp[digit] = temp[digit] + 1;
		}
		
		// 4. Copy all the elements to the output array
		int[] output = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int digit = digitAtPosition(array[i], digitIndex + 1);
			output[i] = array[i];
			temp[digit] = temp[digit] - 1;
		}

		// 4. Copy back the elements of the temp array back to the original array
		for (int i = 0, j = 0; i < temp.length; i++) {
			int rep = temp[i];
			if (rep > 0) {
				for (int k = 0; k < rep; k++) {
					array[j++] = i;
				}
			}
		}
		return array;
	}

	private static int[] radixSort(int[] array) {
		// 1. Find out the max number of digits of an element in the array
		// 1a) For this first we need to find out the highest elements in the array
		int highest = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > highest) {
				highest = array[i];
			}
		}
		// 1b) For the highest find the number of digits
		int digits = 1;
		while (highest > 10) {
			highest = highest / 10;
			digits++;
		}

		// 2. Do the counting sort at all the digit levels
		for (int i = 0; i < digits; i++) {
			array = countingSort(array, i);
		}
		return array;
	}

	public static void main(String[] args) {
		int[] unsortedArray = { 898, 393, 452, 989, 123, 446, 293 };
		System.out.println("Unsorted array elements are : ");
		print(unsortedArray);

		int[] sortedArray = radixSort(unsortedArray);
		System.out.println("\nSorted array elements are : ");
		print(sortedArray);
	}

}
