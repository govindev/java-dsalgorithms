package com.miscellaneous;

public class MaxSumCircularSubArray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("max sum : "+ maxSubarraySumCircular(nums));
    }

    static int maxSubArraySum(int[] nums) {
        int max = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr+nums[i], nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
    public static int maxSubarraySumCircular(int[] nums) {
        // 1. calculate the max of the subarray
        int maxSum = maxSubArraySum(nums);

        // 2. If it smaller than 0 then it is the max possible for the circular subarray
        if (maxSum < 0) return maxSum;

        // 3. Calcualte the prefix sum
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        // 4. Calculate the minium sum
        int minSum = maxSubArraySum(nums);

        // 5. Max will be either maxSum or the total sum subtracted with negative max sum
        return Math.max(maxSum, totalSum+minSum);

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
