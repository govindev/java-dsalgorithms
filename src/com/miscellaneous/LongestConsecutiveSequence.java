package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : nums) {
            // 1. Is it the start of the sequence
            if (!set.contains(num-1)) {
                int length = 1, x = num+1;
                while (set.contains(x)) {
                    length++;
                    x++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
