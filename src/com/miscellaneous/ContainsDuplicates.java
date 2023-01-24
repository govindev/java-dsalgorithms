package com.miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean containsDuplicateUsingSort(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return true;
        }
        return false;
    }

    public boolean containsDuplicateExtraSpace(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
