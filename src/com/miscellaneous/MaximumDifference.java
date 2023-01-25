package com.miscellaneous;

public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minLeft = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minLeft)
                maxDiff = Math.max(maxDiff, nums[i] - minLeft);
            minLeft = Math.min(minLeft, nums[i]);
        }
        return maxDiff;
    }
}
