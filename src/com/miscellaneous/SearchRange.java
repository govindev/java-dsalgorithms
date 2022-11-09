package com.miscellaneous;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return new int[] {-1,-1};
        int last = findLast(nums, target);
        return new int[] {first, last};
    }
    public int findFirst(int[] nums, int target) {
        // Find first
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) return mid;
                right = mid-1;
            }
            else if (nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
    public int findLast(int[] nums, int target) {
        // Find last
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target) return mid;
                left = mid+1;
            }
            else if (nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}
