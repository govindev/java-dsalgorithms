package com.sdesheet.blind;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            // Check if the left is sorted
            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                // explore the right tree
                left = mid+1;
            }
            else {
                // Right is sorted
                min = Math.min(nums[mid], min);
                // Explore the left
                right = mid - 1;
            }
        }
        return min;
    }
}
