package com.sdesheet.blind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        // return longestConsecutiveBySort(nums);
        return longestConsecutiveBySet(nums);
    }

    private int longestConsecutiveBySort(int[] nums) {
        Arrays.sort(nums);
        int currentConsecutiveCount = 0, maxConsecutiveCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i-1]+1) {
                currentConsecutiveCount = 1;
            } else if(nums[i] == nums[i-1]+1) {
                currentConsecutiveCount++;
            }
            maxConsecutiveCount = Math.max(maxConsecutiveCount, currentConsecutiveCount);
        }
        return maxConsecutiveCount;
    }

    private int longestConsecutiveBySet(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }

        int maxConsecutiveCount = 0, currentConsecutiveCount = 0;
        for (int num : nums) {
            if (isStartingElementOfASequence(num, uniqueElements)) {
                currentConsecutiveCount = countConsecutiveSequenceFromStart(num, uniqueElements);
                maxConsecutiveCount = Math.max(maxConsecutiveCount, currentConsecutiveCount);
            }

        }
        return maxConsecutiveCount;
    }

    private boolean isStartingElementOfASequence(int num, Set<Integer> uniqueElements) {
        return !uniqueElements.contains(num - 1);
    }

    private int countConsecutiveSequenceFromStart(int start, Set<Integer> uniqueElements) {
        int consecutiveSequenceCount = 0;
        while (uniqueElements.contains(start++)) {
            consecutiveSequenceCount++;
        }
        return consecutiveSequenceCount;
    }
}
