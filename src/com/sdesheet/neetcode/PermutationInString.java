package com.sdesheet.neetcode;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";

        System.out.println(checkInclusionNaive(s1, s2));
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
