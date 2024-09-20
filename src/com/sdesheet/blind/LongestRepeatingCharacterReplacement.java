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
    public int characterReplacementPartial(String s, int k) {
        int longest = (s.length() == k) ? k : k+1;
        for (int i = 0; i < s.length(); i++) {
            int currK = k;
            int j = i+1;
            for (; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    continue;
                }
                if (currK == 0) {
                    break;
                }
                currK--;
            }
            longest = Math.max(longest, j-i);
        }
        return longest;
    }

    public static int characterReplacement(String s, int k) {
        int[] characterCounts = new int[26];
        int start = 0, end = 0, maxRepChCount = 0, maxWindowLength = 0;
        while (start <= end && end < s.length()) {
            characterCounts[s.charAt(end) - 'A']++;
            maxRepChCount = Math.max(maxRepChCount, characterCounts[s.charAt(end)-'A']);

            int windowLength = end-start+1;
            if (windowLength - maxRepChCount <= k) {
                maxWindowLength = Math.max(maxWindowLength, windowLength);
            } else {
                // If the last substring is not a valid string
                // Then move the left side of the window
                characterCounts[s.charAt(start) - 'A']--;
                start++;
            }
            end++;
        }

        return maxWindowLength;
    }

    // Get the substring
    // Get the count of the character that is most repeating in the substring
    // Check if the length of the substring == count of most rep ch + k
    // Modify the result if it is less than the substring length
    public static int characterReplacementUsingMap(String s, int k) {
            if (s == null) {
                return 0;
            }
            if (s.length() <= k) {
                return s.length();
            }
            int start = 0, end = 0, longestLen = 0, maxCharCount = 0;
            Map<Character, Integer> charCounts = new HashMap<>();
            while (start <= end && end < s.length()) {
                char ch = s.charAt(end);
                int charCount = charCounts.getOrDefault(ch, 0);
                charCounts.put(ch, ++charCount);

                int windowLen = (end - start) + 1;
                maxCharCount = Math.max(charCount, maxCharCount);


                if ((windowLen - maxCharCount) <= k) {
                    // Valid window
                    longestLen = Math.max(windowLen, longestLen);
                } else {
                    // Invalid window
                    char startCh = s.charAt(start);
                    int startCharCount = charCounts.getOrDefault(startCh, 0);
                    charCounts.put(startCh, --startCharCount);
                    start++;
                }
                end++;
            }

            return longestLen;
        }
}

