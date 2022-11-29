package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABABBA";
        s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, res = 0;
        Map<Character, Integer> chCounts = new HashMap<>();
        while (right < s.length()) {
            Character curr = s.charAt(right);
            chCounts.put(curr, chCounts.getOrDefault(curr, 0)+1);

            int maxFreq = 0;
            for (Integer count : chCounts.values()) {
                maxFreq = Math.max(maxFreq, count);
            }

            int winLen = (right - left) + 1;
            if (winLen-maxFreq <= k) {
                res = Math.max(res, winLen);
            } else {
                chCounts.put(s.charAt(left), chCounts.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }
        return res;
    }
}
