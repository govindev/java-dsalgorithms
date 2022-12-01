package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        fourSum(nums, target);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) { // Till last but three elements

            if (i != 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length-2; j++) { // Till last but two elements

                if (j != i+1 && nums[j] == nums[j-1]) continue;


                int left = j+1, right = nums.length-1;
                while (left < right) {
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum == target) {
                        // Found
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < nums.length && nums[left] == nums[left-1]) left++;
                        while (right >= 0 && nums[right] == nums[right+1]) right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}
