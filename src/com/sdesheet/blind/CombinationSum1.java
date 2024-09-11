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

    private void combinationSum(int[] candidates, int target, int current,
                                List<Integer> combination, List<List<Integer>> combinations) {

        if (current == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }

        if (candidates[current] <= target) {
            combination.add(candidates[current]);
            // See if we can pick the current element again
            combinationSum(candidates, target-candidates[current], current, combination, combinations);
            combination.remove(combination.size() - 1);
        }

        combinationSum(candidates, target, current+1, combination, combinations);
    }
}
