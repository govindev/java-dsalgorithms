package com.sdesheet.blind;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], largest = sum;
        for (int end = 1; end < nums.length; end++) {
            sum = Math.max(sum+nums[end], nums[end]);
            largest = Math.max(sum, largest);
        }
        return largest;
    }
}
