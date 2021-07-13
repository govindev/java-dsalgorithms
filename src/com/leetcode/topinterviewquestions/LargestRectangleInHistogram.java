package com.leetcode.topinterviewquestions;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {

	}

	public int largestRectangleArea(int[] heights) {
		long maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int minHeight = heights[i];
			maxArea = heights[i] > maxArea ? heights[i] : maxArea;
			for (int j = i + 1; j < heights.length; j++) {
				if (minHeight > heights[j]) {
					minHeight = heights[j];
				}
				int currentArea = (j - i + 1) * minHeight;
				maxArea = currentArea > maxArea ? currentArea : maxArea;
			}
		}
		return (int) maxArea;
	}
}
