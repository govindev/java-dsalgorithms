package com.miscellaneous;

import java.util.*;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println("String is : " + minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        Map<Character, Integer> tCounts = new HashMap<>();
        Map<Character, Integer> windowCounts = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tCounts.put(ch, tCounts.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0, need = tCounts.size(), have = 0, minWindow = Integer.MAX_VALUE;
        String res = "";

        while (start <= end) {
            if (need == have) {
                if ((end-start) < minWindow) {
                    minWindow = end-start;
                    res = s.substring(start, end);
                }
                // Shrink the window
                Character ch = s.charAt(start);
                if (tCounts.containsKey(ch)) {
                    int prevCount = windowCounts.getOrDefault(ch, 0);
                    if (prevCount == tCounts.get(ch)) {
                        have--;
                    }
                    windowCounts.put(ch, prevCount-1);
                }
                start++;
            }
            else {
                if (end == s.length()) {
                    return res;
                }
                Character ch = s.charAt(end);
                // We don't care about character that are not in the t string
                if (tCounts.containsKey(ch)) {
                    int prevCount = windowCounts.getOrDefault(ch, 0);
                    if (prevCount+1 == tCounts.get(ch)) {
                        have++;
                    }
                    windowCounts.put(ch, prevCount+1);
                }
                end++;
            }
        }
        return res;
    }
}
