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
        Map<Character, Integer> tChCounts = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tChCounts.put(ch, tChCounts.getOrDefault(ch, 0)+1);
        }
        Map<Character, Integer> winChCounts = new HashMap<>();
        int start = 0, matchCount = 0, minWindow = Integer.MAX_VALUE;
        String minWindowStr = "";
        for (int end = 0; end < s.length(); end++) {
            char endCh = s.charAt(end);
            if (!tChCounts.containsKey(endCh)) {
                continue;
            }
            int prevEndChCount = winChCounts.getOrDefault(endCh, 0);
            winChCounts.put(endCh, prevEndChCount+1);

            if (prevEndChCount+1 == tChCounts.get(endCh)) {
                matchCount++;
            }

            while (matchCount == tChCounts.size()) {
                if (end-start+1 < minWindow) {
                    minWindow = end-start+1;
                    minWindowStr = s.substring(start, end+1);
                }

                char startCh = s.charAt(start++);
                if (!tChCounts.containsKey(startCh)) {
                    continue;
                }
                int prevStartChCount = winChCounts.get(startCh);
                winChCounts.put(startCh, prevStartChCount-1);

                if (prevStartChCount == tChCounts.get(startCh)) {
                    matchCount--;
                }
            }
        }
        return minWindowStr;
    }
}
