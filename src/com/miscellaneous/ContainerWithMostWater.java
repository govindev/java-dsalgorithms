package com.miscellaneous;

public class ContainerWithMostWater {
    public int maxAreaNaive(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int maxWater = (j-i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxWater, maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, mostWater = 0;
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            mostWater = Math.max(water, mostWater);
            if (height[left] > height[right]) right--;
            else left++;
        }
        return mostWater;
    }
}
