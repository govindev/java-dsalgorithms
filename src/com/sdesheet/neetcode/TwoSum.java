package com.sdesheet.neetcode;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSumUsingMap(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // Key is number and Value is index
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])) {
                return new int[] {map.get(target-numbers[i])+1, i+1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left]+numbers[right];
            if (sum == target) { return new int[] {left+1, right+1}; }
            if (sum < target) left++; else right--;
        }
        return null;
    }
}
