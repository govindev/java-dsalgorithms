package com.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) return new int[] {i, j};
            }
        }
        Arrays.asList(1,2,3);
        return new int[2];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (positions.containsKey(target - nums[i])) {
                return new int[]{positions.get(target - nums[i]), i};
            }
            positions.put(nums[i], i);
        }
        return null;
    }
}
