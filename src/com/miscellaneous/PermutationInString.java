package com.miscellaneous;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();

        if (l1 > l2) return false;

        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (int i = 0; i < l1; i++) {
            counts1[s1.charAt(i)-'a']++;
            counts2[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            matches += (counts1[i] == counts2[i]) ? 1 : 0;
        }

        int i = l1;
        while (true) {
            if (matches == 26) return true;
            else if (i < l2) {
                int prevChInd = s2.charAt(i-l1) - 'a';
                int nextChInd = s2.charAt(i) - 'a';

                if (counts1[prevChInd] == counts2[prevChInd]) {
                    counts2[prevChInd]--;
                    matches--;
                } else {
                    counts2[prevChInd]--;
                    matches += (counts1[prevChInd] == counts2[prevChInd]) ? 1 : 0;
                }
                if (counts1[nextChInd] == counts2[nextChInd]) {
                    counts2[nextChInd]++;
                    matches--;
                } else {
                    counts2[nextChInd]++;
                    matches += (counts1[nextChInd] == counts2[nextChInd]) ? 1 : 0;
                }
                i++;
            } else return false;
        }

    }


    public boolean checkInclusionNaive(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] counts1 = getCounts(s1);
        int[] counts2 = new int[26];
        int i = 0;
        for (i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            counts2[ch - 'a']++;
        }
        if (areEqual(counts1, counts2)) return true;
        while (i < s2.length()) {

            // remove the first character of the window
            char ch = s2.charAt(i-s1.length());
            counts2[ch - 'a']--;
            // add the next character
            ch = s2.charAt(i);
            counts2[ch - 'a']++;
            if (areEqual(counts1, counts2)) return true;
            i++;
        }
        return false;
    }

    private boolean areEqual(int[] counts1, int[] counts2) {
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) return false;
        }
        return true;
    }

    private int[] getCounts(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            counts[ch - 'a']++;
        }
        return counts;
    }
}
