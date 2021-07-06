package com.leetcode.topinterviewquestions;

public class TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	public static int trap(int[] height) {
		int sMax = 0, pMax = 0;
		int[] sArr = new int[height.length];
		int[] pArr = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			if (height[i] > pMax) {
				pMax = height[i];
			}
			pArr[i] = pMax;
		}
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] > sMax) {
				sMax = height[i];
			}
			sArr[i] = sMax;
		}
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			int currentSum = Math.min(pArr[i], sArr[i]) - height[i];
			if (currentSum > 0)
				sum += currentSum;
		}
		return sum;
	}

	public int trapPartial(int[] height) {
		// doesn't work in situations where the left is greater than the right
		int sum = 0, currentSum = 0, j = 1, i = 0;
		while (i < height.length) {
			if (height[i] == 0 || (i + 1 < height.length && height[i] == height[i + 1]) || (j >= height.length)) {
				i++;
				j = i + 1;
				currentSum = 0;
				continue;
			}
			if (height[i] > height[j]) {
				currentSum += height[i] - height[j];
				j++;
			} else {
				sum += currentSum;
				i = j;
				currentSum = 0;
				j = i + 1;
			}
		}
		return sum;
	}
}
