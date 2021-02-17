package com.challenges.leetcode.twentyone.feb;

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3643/
 * 
 * @author Govind
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int area = (j - i) * (Math.min(height[i], height[j]));
			if (max < area) {
				max = area;
			}
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}
}
