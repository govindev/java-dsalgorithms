package com.miscellaneous;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        // 1. First rotate all elements from left to the last k elements
        int left = 0, right = len-k-1;
        rotate(nums, left, right);

        // 2. Rotate all the last k elements
        left = len-k; right = len-1;
        rotate(nums,left, right);

        // 3. Rotate all the elements of the array
        left = 0; right = len-1;
        rotate(nums,left, right);
    }

    private void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }
}
