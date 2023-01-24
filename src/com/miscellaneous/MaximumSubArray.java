package com.miscellaneous;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(num, sum+num);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
