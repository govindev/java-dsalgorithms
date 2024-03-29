package com.gfg.dsalgo.searching;

public class RepeatingElement {
    public static void main(String[] args) {
        // int[] arr = new int[] {0, 2, 1, 3, 2, 2};
        // int[] arr = new int[] {0, 0};
        int[] arr = new int[] {1, 2, 3, 0, 3, 4, 5};
        System.out.println(repeatingElement(arr));
    }


    private static int repeatingElement(int[] arr) {
        // Rules
        // 1. ArraySize, n>=2
        // 2. Only one element repeats (Any number of times)
        // 3. All the elements from 0 to max(arr) are present

        int total = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            max = Math.max(max, arr[i]);
        }
        int sum = (max) * (max+1) / 2;
        int extra = total - sum;
        return extra / (arr.length-1-max);
    }


    public int findDuplicate(int[] nums) {
        // Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        // There is only one repeated number in nums, return this repeated number.
        int slow = nums[0], fast = slow;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
