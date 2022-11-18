package com.miscellaneous;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }


        reverse(nums, i+1, nums.length-1);
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
