package com.sdesheet.blind;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        // Kadans Algorithm

        int maxSum = nums[0], windowSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= windowSum+nums[i]) {
                windowSum = nums[i];
            } else {
                windowSum += nums[i];
            }

            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}
