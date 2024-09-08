package com.sdesheet.blind;

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

	public int maxArea(int[] height) {
		int leftLine = 0, rightLine = height.length - 1;
		int maxWater = 0;
		while (leftLine < rightLine) {
			int windowWater = Math.min(height[leftLine], height[rightLine]) * (rightLine - leftLine);
			maxWater = Math.max(maxWater, windowWater);

			if (height[leftLine] < height[rightLine]) {
				leftLine++;
			} else {
				rightLine--;
			}
		}
		return maxWater;
	}
}
