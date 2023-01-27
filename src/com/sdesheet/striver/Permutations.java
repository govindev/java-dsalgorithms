package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permuteApproach1(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        func(nums, used, new ArrayList<>(), permutations);
        return permutations;
    }

    private void func(int[] nums, boolean[] used, List<Integer> permutation,
                      List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            permutation.add(nums[i]);
            func(nums, used, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }



    public List<List<Integer>> permuteApproach2(int[] nums) {
        // Better space complexity
        List<List<Integer>> permutations = new ArrayList<>();
        func(nums, 0, permutations);
        return permutations;
    }

    private void func(int[] nums, int ind, List<List<Integer>> permutations) {
        if (ind == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            permutations.add(permutation);
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            func(nums, ind+1, permutations);
            swap(i, ind, nums);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
