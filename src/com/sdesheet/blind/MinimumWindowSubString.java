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
        return minWindowOptimized(s, t);
    }

    public String minWindowOptimized(String s, String t) {
        Map<Character, Integer> tChCounts = getCharCounts(t);
        Map<Character, Integer> winChCounts = new HashMap<>();

        int start = 0, end = 0, minWindowLen = Integer.MAX_VALUE, matchCount = 0;
        String res = "";

        for (; end < s.length(); end++) {
            char endCh = s.charAt(end);
            if (!tChCounts.containsKey(endCh)) {
                continue;
            }

            int prevCount = winChCounts.getOrDefault(endCh, 0);
            winChCounts.put(endCh, prevCount+1);

            if (prevCount+1 == tChCounts.get(endCh)) {
                matchCount++;
            }

            while (matchCount == tChCounts.size()) {
                int windowLen = (end - start) + 1;
                if (windowLen < minWindowLen) {
                    minWindowLen = windowLen;
                    res = s.substring(start, end+1);
                }

                char startCh = s.charAt(start);
                if (tChCounts.containsKey(startCh)) {
                    int prevStartChCount = winChCounts.getOrDefault(startCh, 0);
                    winChCounts.put(startCh, prevStartChCount-1);

                    if (prevStartChCount == tChCounts.get(startCh)) {
                        matchCount--;
                    }
                }
                start++;
            }
        }
        return res;
    }

    private Map<Character, Integer> getCharCounts(String str) {
        Map<Character, Integer> chCounts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            chCounts.put(ch, chCounts.getOrDefault(ch, 0)+1);
        }
        return chCounts;
    }
}
