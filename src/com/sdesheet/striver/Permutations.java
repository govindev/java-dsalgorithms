package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
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
}
