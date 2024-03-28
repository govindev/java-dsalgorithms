package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 1. First sort the array to avoid duplicates
        Arrays.sort(nums);

        // 2. Declare the response
        List<List<Integer>> triplets = new ArrayList<>();

        if (nums.length < 3) return triplets;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left-1]) { left++; }
                }
                else if (sum > 0) right--;
                else left++;
            }
        }
        return triplets;
    }
}
