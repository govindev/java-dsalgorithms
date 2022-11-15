package com.miscellaneous;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2,3};
        int target = 0;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int pivot = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) return mid;
            else if (mid-1 >= low && nums[mid] > nums[mid-1] && nums[mid] > nums[low]) {
                // Left half is sorted
                if (target >= nums[low] && target <= nums[mid-1]) high = mid-1;
                else low = mid+1;
            } else {
                // Right half is sorted
                if (mid+1 <= high && target >= nums[mid+1] && target <= nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}
