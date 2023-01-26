package com.miscellaneous;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || k%nums.length == 0) return;
        int len = nums.length;
        k = k % len;

        // 1. First rotate first len-k elements
        int left = 0, right = len-k-1;
        rotate(nums, left, right);

        // 2. Then, Rotate the last k elements
        left = len-k; right = len-1;
        rotate(nums, left, right);

        // 3. Now, Rotate the entire array
        left = 0; right = len-1;
        rotate(nums, left, right);

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
