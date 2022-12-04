package com.sdesheet.neetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        // String s = "ADOBECODEBANC", t = "ABC";

        String s = "aaaaaaaaaaaabbbbbcdd",
        t = "abcdd";

        System.out.println(minWindow(s, t));
    }

    // Using HashMap, Sliding Window / Two-Pointer approach
    public static String minWindow(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        String res = "";

        if (l2 > l1) return res;

        Map<Character, Integer> counts1 = new HashMap<>(), counts2 = new HashMap<>();

        for (int i = 0; i < l2; i++) {
            Character ch = t.charAt(i);
            counts2.put(ch, counts2.getOrDefault(ch, 0) + 1);
        }
        int need = counts2.size();
        int have = 0, min = Integer.MAX_VALUE;


        int left = 0, right = 0;
        while (left <= right) {
            if (have == need) {
                if ((right-left) < min) {
                    res = s.substring(left, right);
                    min = right-left;
                }

                // Shrink window from left
                Character ch = s.charAt(left);

                if (counts2.containsKey(ch)) {
                    counts1.put(ch, counts1.getOrDefault(ch, 0) - 1);

                    if (counts1.get(ch) < counts2.get(ch)) have--;
                }

                left++;
            } else {
                if (right == l1) return res;
                Character ch = s.charAt(right);

                if (counts2.containsKey(ch)) {
                    counts1.put(ch, counts1.getOrDefault(ch, 0) + 1);

                    if (counts1.get(ch) == counts2.get(ch)) have++;
                }
                right++;
            }
        }
        return res;
    }
}
