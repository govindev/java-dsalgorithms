package com.miscellaneous;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // Use the two pointer approach
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[] {left+1, right+1};
            else if (sum > target) right--;
            else left++;
        }
        return null;
    }
}
