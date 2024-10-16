package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        int start = 0, max = 0;
        for (int end = 0; end < s.length(); end++) {
            char endCh = s.charAt(end);
            int endChCount = counts.getOrDefault(endCh, 0);
            endChCount++;
            counts.put(endCh, endChCount);
            if (endChCount == 1) {
                int length = (end-start)+1;
                max = Math.max(max, length);
            }
            while (counts.get(endCh) > 1) {
                char startCh = s.charAt(start);
                int startChCount = counts.get(startCh);
                startChCount--;
                counts.put(startCh, startChCount);
                start++;
            }
        }
        return max;
    }
}
