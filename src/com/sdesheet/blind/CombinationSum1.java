package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinations(candidates, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinations(int[] candidates, int current, int target,
                              List<Integer> combination, List<List<Integer>> combinations) {

        if (current == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }

        if (target >= candidates[current]) {
            combination.add(candidates[current]);
            combinations(candidates, current, target-candidates[current], combination, combinations);
            combination.remove(combination.size() - 1);
        }


        combinations(candidates, current+1, target, combination, combinations);

    }
}
