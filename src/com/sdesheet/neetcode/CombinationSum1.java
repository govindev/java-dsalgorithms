package com.sdesheet.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();

        return combinationSum(candidates, target, 0, new ArrayList<>(), combinations);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int start, List<Integer> prevComb, List<List<Integer>> combinations) {

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i-1]) continue;
            int x = candidates[i];
            List<Integer> combination = new ArrayList<>();
            combination.addAll(prevComb);
            while (x <= target) {
                combination.add(candidates[i]);
                if (x == target) {
                    combinations.add(combination);
                    break;
                }
                combinations = combinationSum(candidates, target-x, i+1, combination, combinations);
                x += candidates[i];
            }
        }
        return combinations;
    }
}
