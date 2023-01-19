package com.miscellaneous;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1. Find the index1
        int index1 = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                index1 = i;
                break;
            }
        }

        // 2. Find the index2
        int index2 = -1;
        // check if the index1 is valid
        if (index1 >= 0)
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }

        // 3. Swap the index1 and index2 values
        if (index1 >= 0 && index2 >= 0) {
            swap(nums, index1, index2);
        }

        // 4. Reverse all the numbers after the index1
        int left = index1 + 1, right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++; right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
