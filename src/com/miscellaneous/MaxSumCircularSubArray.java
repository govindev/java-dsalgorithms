package com.miscellaneous;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("max sum : "+ maxSubarraySumCircular(nums));
    }

    public static int maxSum(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = (nums[i] > nums[i]+currSum) ? nums[i] : currSum + nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int maxSum = maxSum(nums);

        if (maxSum < 0) return maxSum;

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int minSum = maxSum(nums);

        return Math.max(maxSum, totalSum + minSum);
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
