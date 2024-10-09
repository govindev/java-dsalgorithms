package com.sdesheet.blind;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea(height));
	}

	public int maxArea(int[] height) {
		// Two pointer approach
		int left = 0, right = height.length-1;
		int maxWater = Integer.MIN_VALUE;
		while (left < right) {
			int currentWater = (right-left) * Math.min(height[left], height[right]);
			maxWater = Math.max(maxWater, currentWater);
			if (height[left] > height[right]) {
				right--;
			}
			else {
				left++;
			}
		}
		return maxWater;
	}
}
