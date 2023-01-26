package com.miscellaneous;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        // One Pass algorithm
        int left = 0, right = nums.length-1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
            }
            i++;
        }
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColorsTwoPass(int[] nums) {
        // Two pass algorithm
        int zeros = 0, ones = 0, twos = 0;
        for (int num : nums) {
            if (num == 0) zeros++;
            else if (num == 1) ones++;
            else twos++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                nums[i] = 0; zeros--;
            } else if (ones > 0) {
                nums[i] = 1; ones--;
            } else {
                nums[i] = 2; twos--;
            }
        }

    }
}
