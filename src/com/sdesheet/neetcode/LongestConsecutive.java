package com.sdesheet.neetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 1;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int current = 1;
                while (set.contains(num+1)) { current++; num++; }
                longest = Math.max(longest, current);
            }
        }
        return longest;
    }
}
