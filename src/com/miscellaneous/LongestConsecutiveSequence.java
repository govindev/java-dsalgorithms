package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxCount = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int curr = 1;
            while (set.contains(num+1)) { curr++; num++; }
            maxCount = Math.max(curr, maxCount);
        }
        return maxCount;
    }
}
