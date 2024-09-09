package com.sdesheet.blind;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // return groupAnagramsTimeout(strs);
        return groupAnagramsOptimized(strs);
    }

    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            String key = getKeyForStr(str);

            List<String> anagrams = anagramGroups.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            anagramGroups.put(key, anagrams);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    private String getKeyForStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



    public List<List<String>> groupAnagramsTimeout(String[] strs) {
        List<List<String>> anagramsGroups = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;

            List<String> anagramsGroup = new ArrayList<>();
            anagramsGroup.add(strs[i]);

            for (int j = i+1; j < strs.length; j++) {
                if (strs[j] == null) continue;

                if (areAnagrams(strs[i], strs[j])) {
                    anagramsGroup.add(strs[j]);
                    strs[j] = null;
                }
            }

            anagramsGroups.add(anagramsGroup);
            strs[i] = null;
        }

        return anagramsGroups;
    }

    private boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        Map<Character, Integer> s1ChCounts = getCharacterCounts(s1);
        Map<Character, Integer> s2ChCounts = getCharacterCounts(s2);

        for (Character ch : s1ChCounts.keySet()) {
            if (s1ChCounts.get(ch) != s2ChCounts.get(ch)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getCharacterCounts(String str) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            characterCounts.put(ch, characterCounts.getOrDefault(ch, 0)+1);
        }
        return characterCounts;
    }

}
