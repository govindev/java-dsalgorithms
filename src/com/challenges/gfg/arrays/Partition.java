package com.challenges.gfg.arrays;

/**
 * In the given input array for the given element value x change the array such
 * that x should be placed at the right place. Meaning elements less than x
 * should be to the left of the array and elements which are greater than x
 * should placed to the right side of the array
 * 
 * @author Govind
 *
 */
public class Partition {
	public static void main(String[] args) {
		// Assume the array is
		int[] array = { 2, 5, 8, 12, 3, 7, 9, 1 };
		// element is value at the index 5
		int eIndex = 3;
		int element = array[eIndex];
		int left = 0;
		int right = array.length - 1;
		int[] temp = new int[array.length];
		int i = 0;
		while (left < right || i < array.length) {
			if (array[i] < element) {
				temp[left] = array[i];
				left++;
			} else if (array[i] > element) {
				temp[right] = array[i];
				right--;
			}

			i++;
		}
		temp[left] = element;
		for (int e : temp) {
			System.out.print(e + ",");
		}

	}
}
