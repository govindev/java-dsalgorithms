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

    private Set<Integer> uniqueNums = new HashSet<>();

    public int longestConsecutiveBySet(int[] nums) {
        uniqueNums = new HashSet<>();

        for (int num : nums) {
            uniqueNums.add(num);
        }

        int maxSequenceLength = 0;
        for (int num : nums) {
            if (isStartOfSequence(num)) {
                int currSequenceLength = lengthOfSequenceThatStartsAt(num);
                maxSequenceLength = Math.max(currSequenceLength, maxSequenceLength);
            }
        }

        return maxSequenceLength;
    }

    private boolean isStartOfSequence(int num) {
        return !uniqueNums.contains(num-1);
    }

    private int lengthOfSequenceThatStartsAt(int num) {
        int length = 0;
        while (uniqueNums.contains(num++)) {
            length++;
        }
        return length;
    }
}
