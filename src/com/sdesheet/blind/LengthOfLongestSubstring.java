package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        int left = 0, right = 0, maxLength = 0;
        while (left <= right && right < s.length()) {
            char currentCh = s.charAt(right);
            int prevCountOfChar = characterCounts.getOrDefault(currentCh, 0);
            if (prevCountOfChar > 0) {
                moveLeft(left, s, characterCounts);
                left++;
            } else {
                characterCounts.put(currentCh, 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
        }

        return maxLength;
    }

    private void moveLeft(int left, String s, Map<Character, Integer> characterCounts) {
        char leftCh = s.charAt(left);
        characterCounts.put(leftCh, characterCounts.getOrDefault(leftCh, 1) - 1);
    }
}
