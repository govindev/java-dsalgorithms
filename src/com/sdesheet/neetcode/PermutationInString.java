package com.sdesheet.neetcode;

public class PermutationInString {
    public static void main(String[] args) {
//        String s1 = "adc", s2 = "dcda";
        String s1 = "abc", s2 = "bbbca";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] chCounts1 = new int[26];
        int[] chCounts2 = new int[26];
        int i = 0, l1 = s1.length(), l2 = s2.length(), matches = 0;

        for (; i < l1; i++) {
            chCounts1[s1.charAt(i) - 'a']++;
            chCounts2[s2.charAt(i) - 'a']++;
        }

        // Calculate the matches
        for (i = 0; i < 26; i++) {
            if (chCounts1[i] == chCounts2[i]) matches++;
        }

        i = l1;
        while (true) {
            if (matches == 26) return true;
            else if (i < l2) {
                int prevChInd = s2.charAt(i-l1) - 'a';
                int nextChInd = s2.charAt(i) - 'a';

                if (chCounts1[prevChInd] == chCounts2[prevChInd]) {
                    chCounts2[prevChInd]--;
                    matches += (chCounts1[prevChInd] == chCounts2[prevChInd]) ? 0 : -1;
                } else {
                    chCounts2[prevChInd]--;
                    matches += (chCounts1[prevChInd] == chCounts2[prevChInd]) ? 1 : 0;
                }
                if (chCounts1[nextChInd] == chCounts2[nextChInd]) {
                    chCounts2[nextChInd]++;
                    matches += (chCounts1[nextChInd] == chCounts2[nextChInd]) ? 0 : -1;
                } else {
                    chCounts2[nextChInd]++;
                    matches += (chCounts1[nextChInd] == chCounts2[nextChInd]) ? 1 : 0;
                }
                i++;
            } else {
                return false;
            }
        }
    }

    public static boolean checkInclusionNaive(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] chCounts1 = new int[26];
        int[] chCounts2 = new int[26];
        int i = 0, l1 = s1.length(), l2 = s2.length();

        for (; i < l1; i++) {
            chCounts1[s1.charAt(i) - 'a']++;
            chCounts2[s2.charAt(i) - 'a']++;
        }

        while(true) {
            if (equals(chCounts1, chCounts2)) {
                return true;
            } else if (i < l2) {
                chCounts2[s2.charAt(i-l1) - 'a']--;
                chCounts2[s2.charAt(i++) - 'a']++;
            } else {
                return false;
            }
        }
    }

    private static boolean equals(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
}
