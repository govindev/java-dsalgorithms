package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayWithEqual1sAnd0s {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
            sum += nums[i];
            if (sum == 0) {
                maxLength = i+1;
            } else if (sums.containsKey(sum)) {
                // This sum is seen before
                int len = i-sums.get(sum);
                maxLength = Math.max(maxLength, len);
            } else {
                sums.put(sum, i);
            }
        }
        return maxLength;
    }

    public int findMaxLengthNaive(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int zerosCount = 0, onesCount = 0;
            if (nums[i] == 0) zerosCount++;
            else onesCount++;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == 0) zerosCount++;
                else onesCount++;
                if (zerosCount == onesCount)
                    maxLength = Math.max(zerosCount+onesCount, maxLength);
            }
        }
        return maxLength;
    }
}
