package com.sdesheet.blind;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        System.out.println("String is : " + minimumWindowSubString.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        // Maintain two arrays of size 26 to store the counts of characters in s & t
        // Use the sliding window technique
        // right pointer keeps going to the right
        // when the count of a character matches decrease the need value
        // when the count of a character just stops matching increase the need value
        // when the need becomes zero move the left side of the window
        // when right reaches the end stop and return the result.
        Map<Character, Integer> tChCounts = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tChCounts.put(ch, tChCounts.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> sChCounts = new HashMap<>();
        String res = "";
        int start = 0, need = tChCounts.size(), have = 0, length = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (!tChCounts.containsKey(ch)) {
                continue;
            }
            int endsPrevCount = sChCounts.getOrDefault(ch, 0);
            if (endsPrevCount+1 == tChCounts.get(ch)) {
                have++;
            }
            sChCounts.put(ch, endsPrevCount+1);
            while (need == have && start <= end) {
                if (length > end-start) {
                    res = s.substring(start, end+1);
                    length = end-start;
                }
                char startCh = s.charAt(start);
                if (sChCounts.containsKey(startCh)) {
                    int startsPrevCount = sChCounts.get(startCh);
                    if (startsPrevCount == tChCounts.get(startCh)) {
                        have--;
                    }
                    sChCounts.put(startCh, startsPrevCount-1);
                }
                start++;
            }
        }
        return res;
    }
}
