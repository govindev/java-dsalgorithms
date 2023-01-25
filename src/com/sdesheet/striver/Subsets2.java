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
        // return subsets;

        // Method2
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size()-1);
        }
    }


    public List<List<Integer>> getSubsets(int[] nums, int from, List<Integer> subset, List<List<Integer>> subsets) {
        for (int i = from; i < nums.length; i++) {
            if (i != from && nums[i] == nums[i-1]) continue;

            List<Integer> list = new ArrayList<>(subset);
            list.add(nums[i]);
            subsets.add(list);

            subsets = getSubsets(nums, i+1, list, subsets);
        }
        return subsets;
    }
}
