package com.gfg.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num == 0 ? -1 : 1;
            if (sum == 0) maxLength = Math.max(maxLength, i+1);
            else if (sums.containsKey(sum)) {
                int len = i-sums.get(sum);
                maxLength = Math.max(maxLength, len);
            } else {
                sums.put(sum, i);
            }
        }
        return maxLength;
    }
}
