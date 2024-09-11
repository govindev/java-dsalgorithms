package com.sdesheet.blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // return twoSumUsingArrayCopy(nums, target);

        return twoSumUsingMap(nums, target);
    }

    public int[] twoSumUsingMap(int[] nums, int target) {
        Map<Integer, Integer> elmIndMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int elmToFind = target - nums[i];

            if (elmIndMap.containsKey(elmToFind)) {
                return new int[] {elmIndMap.get(elmToFind), i};
            }

            elmIndMap.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSumUsingArrayCopy(int[] nums, int target) {
        int[] copy = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            copy[i++] = num;
        }

        Arrays.sort(copy);
        int left = 0, right = copy.length - 1;
        while (left < right) {
            int sum = copy[left]+copy[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        int index1 = -1, index2 = -1;
        for (i = 0; i < nums.length; i++) {
            if (index1 == -1 && nums[i] == copy[left]) {
                index1 = i;
            } else if (index2 == -1 && nums[i] == copy[right]) {
                index2 = i;
            }
        }

        return new int[] {index1, index2};
    }
}
