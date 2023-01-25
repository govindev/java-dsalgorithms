package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 1. Sort the Array
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(List.of());
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            subsets.add(List.of(nums[i]));
            subsets = getSubsets(nums, i+1, List.of(nums[i]), subsets);
        }
        return subsets;
    }

    public List<List<Integer>> getSubsets(int[] nums, int from, List<Integer> subset, List<List<Integer>> subsets) {
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i] == nums[i-1]) continue;

            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.addAll(subset);
            subsets.add(list);

            subsets = getSubsets(nums, i+1, list, subsets);
        }
        return subsets;
    }
}
