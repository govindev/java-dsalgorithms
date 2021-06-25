package com.challenges.gfg.arrays;

public class RepeatingElement {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1, 1 };
		int length = array.length;
		int sum = 0;
		int max = 0;
		// 1. Find the highest element in the array
		// 2. Also find the sum of the array
		for (int i = 0; i < length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			sum += array[i];
		}
		// 3. Supposed to be sum
		int sSum = (max) * (max + 1) / 2;
		System.out.println("Repeating element is : " + (sum - sSum) / (length - max));
	}
}
