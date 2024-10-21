package com.sdesheet.blind;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[left] <= nums[mid]) {
                // left is sorted
                min = Math.min(min, nums[left]);
                // explore right
                left = mid+1;
            } else {
                // right is sorted
                min = Math.min(min, nums[mid]);
                // explore left
                right = mid-1;
            }
        }
        return min;
    }
}
