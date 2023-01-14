package com.sdesheet.neetcode;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, right = 0, maxCount = 0, longest = 0;

        while (left <= right && right < s.length()) {
            Character ch = s.charAt(right);
            counts[ch-'A']++;
            maxCount = Math.max(counts[ch-'A'], maxCount);

            // Is valid window
            // windowLength - maxCount <= k
            if ((right-left)+1 - maxCount <= k) {
                longest = right-left+1;
            } else {
                // Slide the start of the window
                ch = s.charAt(left);
                counts[ch-'A']--;
                left++;
            }
            right++;
        }
        return longest;
    }
}
