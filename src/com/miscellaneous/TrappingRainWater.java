package com.miscellaneous;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        lmax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(height[i-1], lmax[i-1]);
        }
        rmax[height.length-1] = 0;
        for (int i = height.length-2; i >= 0; i--) {
            rmax[i] = Math.max(height[i+1], rmax[i+1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int water = Math.min(lmax[i], rmax[i]) - height[i];
            sum = Math.max(sum+water, sum);
        }
        return sum;
    }
}
