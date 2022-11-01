package com.miscellaneous;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("max sum : "+ maxSubarraySumCircular(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        // Brute force
        int maxSum = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, maxSumFrom(nums, i, len));
        }
        return maxSum;
    }

    public static int maxSumFrom(int[] nums, int start, int len) {
        int maxSum = nums[start];
        int currSum = nums[start];

        for (int l = 1; l < len; l++) {
            int i = (start+l) % len;
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
