package com.sdesheet.blind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // 3 solutions

        // 1. order of n square. Two loops
        // return containsDuplicateWithoutExtraSpace(nums);

        // 2. order of logn do the sort
        // return containsDuplicateUsingSort(nums);

        // 3. order of 1 have the set
        return containsDuplicateUsingSet(nums);

    }

    public boolean containsDuplicateWithoutExtraSpace(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }

    public boolean containsDuplicateUsingSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }

        return false;
    }

    public boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) return true;
            uniqueNums.add(num);
        }

        return false;
    }
}
