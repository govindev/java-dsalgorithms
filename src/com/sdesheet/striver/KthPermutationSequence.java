package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        k = k-1;
        String ans = "";
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            numbers.add(i);
            fact *= i;
        }
        numbers.add(n);

        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) break;

            k %= fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
    public String getPermutationBruteForce(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        List<String> combinations = new ArrayList<>();
        func("", nums, combinations, n, k);
        return combinations.get(k-1);
    }

    private void func(String curr, List<Integer> nums, List<String> combinations, int n, int k) {
        if (combinations.size() == k) return;
        if (curr.length() == n) {
            combinations.add(curr);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (combinations.size() == k) return;
            int num = nums.get(i);
            nums.remove(i);
            func(curr + num, nums, combinations, n, k);
            nums.add(i, num);
        }
    }
}
