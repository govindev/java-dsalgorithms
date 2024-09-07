package com.miscellaneous;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;

        // return isAnagramUnOptimized(s, t);
        return isAnagramOptimized(s, t);

    }

    public boolean isAnagramOptimized(String s, String t) {
        int[] chCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chCounts[s.charAt(i) - 'a']++;
            chCounts[t.charAt(i) - 'a']--;
        }

        for (int count : chCounts) {
            if (count != 0) return false;
        }

        return true;
    }

    public boolean isAnagramUnOptimized(String s, String t) {
        int[] sChCounts = new int[26];
        fillCharacterCounts(s, sChCounts);

        int[] tChCounts = new int[26];
        fillCharacterCounts(t, tChCounts);

        return hasEqualCharacterCounts(sChCounts, tChCounts);
    }

    private void fillCharacterCounts(String str, int[] counts) {
        for (char ch : str.toCharArray()) {
            counts[ch-'a']++;
        }
    }

    private boolean hasEqualCharacterCounts(int[] chCounts1, int[] chCounts2) {
        for (int i = 0; i < chCounts1.length; i++) {
            if (chCounts1[i] != chCounts2[i]) return false;
        }
        return true;
    }
}
