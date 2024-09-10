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
        // return minWindowLeftMoveFirst(s, t);

        return minWindowOptimized(s, t);
    }

    public String minWindowOptimized(String s, String t) {
        int countParity = 0;
        Map<Character, Integer> tChCounts = getCharacterCounts(t);
        Map<Character, Integer> sChCounts = new HashMap<>();
        String minWindowStr = "";
        int minWindowLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!tChCounts.containsKey(ch)) {
                continue;
            }
            int prevCount = sChCounts.getOrDefault(ch, 0);
            if (prevCount + 1 == tChCounts.get(ch)) {
                countParity++;
            }
            sChCounts.put(ch, prevCount+1);

            while (countParity == tChCounts.size() && left <= right) {
                int windowLen = right - left + 1;
                if (windowLen < minWindowLen) {
                    minWindowStr = s.substring(left, right+1);
                }

                char leftCh = s.charAt(left);
                if (!tChCounts.containsKey(leftCh)) { left++;  continue; }

                if (sChCounts.get(leftCh) == tChCounts.get(leftCh)) {
                    countParity--;
                }
                sChCounts.put(leftCh, sChCounts.get(leftCh)-1);
                left++;

            }
        }

        return minWindowStr;
    }

    public String minWindowLeftMoveFirst(String s, String t) {
        Map<Character, Integer> sChCounts = getCharacterCounts(s);
        Map<Character, Integer> tChCounts = getCharacterCounts(t);

        for (char ch : t.toCharArray()) {
            if (tChCounts.get(ch) > sChCounts.getOrDefault(ch, 0)) return "";
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftCh = s.charAt(left);
            if (!tChCounts.containsKey(leftCh)) {
                left++;
                continue;
            }
            if (sChCounts.get(leftCh) > tChCounts.get(leftCh)) {
                sChCounts.put(leftCh, sChCounts.get(leftCh) - 1);
                left++;
                continue;
            }
            break;
        }

        while (left < right) {
            char rightCh = s.charAt(right);
            if (!tChCounts.containsKey(rightCh)) {
                right--;
                continue;
            }
            if (sChCounts.get(rightCh) > tChCounts.get(rightCh)) {
                sChCounts.put(rightCh, sChCounts.get(rightCh) - 1);
                right--;
                continue;
            }
            break;
        }


        return s.substring(left, right+1);
    }

    private Map<Character, Integer> getCharacterCounts(String str) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            characterCounts.put(ch, characterCounts.getOrDefault(ch,0)+1);
        }
        return characterCounts;
    }
}
