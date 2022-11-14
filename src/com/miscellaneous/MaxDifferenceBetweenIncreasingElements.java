package com.miscellaneous;

public class MaxDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = nums[0], maxDiff = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                maxDiff = Math.max(maxDiff, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return maxDiff;
    }
    public int maximumDifferenceWithExtraSpace(int[] nums) {
        int len = nums.length;
        int[] rMax = new int[len];
        rMax[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], nums[i+1]);
        }
        int maxDiff = -1;
        for (int i = 0; i < len-1; i++) {
            if (rMax[i] > nums[i])
                maxDiff = Math.max(rMax[i] - nums[i], maxDiff);
        }
        return maxDiff;
    }
}
