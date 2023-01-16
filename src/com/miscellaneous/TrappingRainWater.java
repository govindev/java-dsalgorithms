package com.miscellaneous;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] lMax = new int[n], rMax = new int[n];
        lMax[0] = 0;
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i-1]);
        }
        rMax[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i+1]);
        }

        int maxWater = 0;
        for (int i = 0; i < n; i++) {
            maxWater += Math.max(Math.min(lMax[i], rMax[i]) - height[i], 0);
        }
        return maxWater;
    }
}
