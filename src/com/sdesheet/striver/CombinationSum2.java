package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();

        // Method 1
        // getCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        // Method 2
        findCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        return combinations;
    }

    private void findCombinations(int[] candidates, int target, int ind, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;

            ds.add(candidates[i]);
            findCombinations(candidates, target-candidates[i], i+1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }


    private void getCombinations(int[] candidates, int target, int start, List<Integer> prevComb, List<List<Integer>> combinations) {
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] <= target) {
                List<Integer> combination = new ArrayList<>(prevComb);
                combination.add(candidates[i]);
                if (candidates[i] == target) {
                    combinations.add(combination);
                }
                getCombinations(candidates, target-candidates[i], i+1, combination, combinations);
            }
        }
    }
}
