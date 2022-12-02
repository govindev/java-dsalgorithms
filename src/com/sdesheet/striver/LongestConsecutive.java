package com.sdesheet.striver;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (set.contains(num-1)) continue;
            int next = num+1, count = 1;
            while (set.contains(next++)) count++;
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
