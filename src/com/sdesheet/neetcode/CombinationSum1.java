package com.sdesheet.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();

        // Method 1
        // combinationSum(candidates, target, 0, new ArrayList<>(), combinations);

        // Method 2
        findCombinations(0, candidates, target, combinations, new ArrayList<>());

        return combinations;
    }

    private void combinationSum(int[] candidates, int target, int start, List<Integer> prevComb, List<List<Integer>> combinations) {

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
                combinationSum(candidates, target-x, i+1, combination, combinations);
                x += candidates[i];
            }
        }
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1, arr, target, ans, ds);
    }
}
