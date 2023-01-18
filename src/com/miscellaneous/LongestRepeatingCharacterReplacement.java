package com.miscellaneous;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, right = 0, maxLength = 0, maxCount = 0;
        while (left <= right && right < s.length()) {
            Character ch = s.charAt(right);
            counts[ch - 'A']++;
            maxCount = Math.max(maxCount, counts[ch-'A']);

            if ((right-left)+1 - maxCount <= k) {
                // Valid window
                maxLength = Math.max(maxLength, (right-left)+1);
            } else {
                // slide the window from the left side
                ch = s.charAt(left);
                counts[ch - 'A']--;
                left++;
            }
            right++;
        }
        return maxLength;
    }
}
