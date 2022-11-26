package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length-1;
            while (left < right) {
                if (nums[i]+nums[left]+nums[right] == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < nums.length-1 && nums[left] == nums[left+1]) left++; left++;
                    while (right > 0 && nums[right] == nums[right-1]) right--; right--;
                } else if (nums[i]+nums[left]+nums[right] > 0) {
                    while (right > 0 && nums[right] == nums[right-1]) right--; right--;
                } else {
                    while (left < nums.length-1 && nums[left] == nums[left+1]) left++; left++;
                }
            }
        }
        return triplets;
    }
}
