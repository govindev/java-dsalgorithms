package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) right--;
                    else if (sum < target) left++;
                    else {
                        quadruplets.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        right--;
                        left++;
                        while (left < right && nums[right] == nums[right+1]) right--;
                        while (left < right && nums[left] == nums[left-1]) left++;
                    }
                }
            }
        }
        return quadruplets;
    }
}
