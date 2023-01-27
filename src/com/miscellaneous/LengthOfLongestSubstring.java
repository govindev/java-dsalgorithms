package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOccurances = new HashMap<>();
        int left = 0, right = 0, longest = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (lastOccurances.getOrDefault(ch, -1) >= left) {
                left = lastOccurances.get(ch) + 1;
                lastOccurances.remove(ch);
            }

            lastOccurances.put(ch, right);
            longest = Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}
