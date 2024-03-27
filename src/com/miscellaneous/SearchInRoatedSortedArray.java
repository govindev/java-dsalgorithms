package com.miscellaneous;

import java.util.Arrays;

public class SearchInRoatedSortedArray {
    public int search(int[] nums, int target) {

        String str = "govind";
        char[] array = str.toCharArray();
        Arrays.sort(array);
        new String(array);

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[low] <= nums[mid]) {
                // left half is sorted
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                // righ half is sorted
                if (target >= nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
