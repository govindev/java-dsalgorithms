package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();

        int left = 0, right = 0, longestLen = 0;
        while (left <= right && right < s.length()) {
            char ch = s.charAt(right);
            int charCount = charCounts.getOrDefault(ch, 0);
            if (charCount == 1) {
                char leftCh = s.charAt(left);
                charCounts.put(leftCh, 0);
                left++;
                continue;
            }
            charCounts.put(ch, 1);

            int windowLen = (right - left) + 1;
            longestLen = Math.max(windowLen, longestLen);

            right++;
        }

        return longestLen;
    }
}
