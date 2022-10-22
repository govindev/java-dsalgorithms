package com.sdesheet.neetcode;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea1(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int water = (j - i) * Math.min(height[i], height[j]);
				max = water > max ? water : max;
			}
		}
		return max;
	}

	public static int maxArea(int[] height) {
		// order of n solution with two pointers
		int i = 0, j = height.length - 1, max = 0;
		while (i < j) {
			int min = Math.min(height[i], height[j]);
			int water = (j - i) * min;
			max = water > max ? water : max;
			if (height[i] == min) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}
}
