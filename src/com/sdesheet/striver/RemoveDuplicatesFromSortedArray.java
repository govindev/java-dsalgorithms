package com.sdesheet.striver;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;

        while (i < nums.length && j < nums.length) {
            if (i == 0 || nums[i] > nums[i-1]) {
                i++;
                if (i <= j) j = i+1;
            } else if (nums[j] > nums[i-1]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j++;
            } else j++;
        }
        return i;
    }
}
