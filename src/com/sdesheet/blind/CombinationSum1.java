package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    public void combinationSum(int[] candidates, int target, int current,
                               List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
        }
        if (current >= candidates.length) {
            return;
        }
        if (candidates[current] <= target) {
            // Pick
            combination.add(candidates[current]);
            combinationSum(candidates, target - candidates[current], current, combination, combinations);
            combination.removeLast();
        } else {
            return;
        }

        // Not pick
        combinationSum(candidates, target, current+1, combination, combinations);
    }
}
