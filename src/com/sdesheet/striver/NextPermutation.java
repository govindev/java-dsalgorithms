package com.sdesheet.striver;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        // 1. Find the index i where nums[i] < nums[i+1]
        int i = nums.length-2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]) break;
        }
        if (i >= 0) {
            // 2. Find the index j where nums[j] > nums[i]
            int j = nums.length-1;
            for (; j >= 0; j--) {
                if (nums[j] > nums[i]) break;
            }
            if (j >= 0) {
                // 3. Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 4. Reverse elements after i
        int left = i+1, right = nums.length-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}
