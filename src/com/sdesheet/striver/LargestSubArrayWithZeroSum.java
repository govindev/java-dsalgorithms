package com.sdesheet.striver;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    int maxLen(int arr[], int n)
    {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) maxLen = i+1;
            else if (prefixSums.containsKey(sum)) maxLen = Math.max(maxLen, i-prefixSums.get(sum));
            else prefixSums.put(sum, i);
        }
        return maxLen;
    }
}
