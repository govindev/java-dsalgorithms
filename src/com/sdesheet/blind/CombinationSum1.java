package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();

        combinationSum(candidates, target, 0, combination, combinations);

        return combinations;
    }

    public void combinationSum(int[] candidates, int target, int ind,
                               List<Integer> combination, List<List<Integer>> combinations) {

        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (ind == candidates.length) {
            return;
        }

        int candidate = candidates[ind];
        if (candidate <= target) {
            // I can pick
            combination.add(candidate);
            combinationSum(candidates, target - candidate, ind, combination, combinations);
            combination.removeLast();
        } else {
            return;
        }
        combinationSum(candidates, target, ind + 1, combination, combinations);
    }
}
