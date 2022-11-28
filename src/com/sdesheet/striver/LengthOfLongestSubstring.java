package com.sdesheet.striver;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOccs = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            Character ch = s.charAt(right);
            if (lastOccs.getOrDefault(ch, -1) >= left) {
                left = lastOccs.get(ch) + 1;
                lastOccs.remove(ch);
            }
            lastOccs.put(ch, right);
            max = Math.max((right-left)+1, max);
            right++;
        }
        return max;
    }
}
