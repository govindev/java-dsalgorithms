package com.miscellaneous;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("max sum : "+ maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        // 1. Find the max of the normal array
        int maxSum = maxSum(nums);
        if (maxSum < 0) return maxSum;
        // 2. Find the total sum
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = 0 - nums[i];
        }
        // 3. Find the minimum of the array
        int minSum = maxSum(nums);
        // 4. Return the max of the normal array max sum and totalsum + min array sum
        return Math.max(maxSum, totalSum+minSum);
    }

    private static int maxSum(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubarraySumCircularNaive(int[] nums) {
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
