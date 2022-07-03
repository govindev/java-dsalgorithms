package com.sdesheet.blind;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        // Using the sorting technique
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> groupsMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            char[] chars = current.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!groupsMap.containsKey(sorted)) {
                groupsMap.put(sorted, new ArrayList<>());
            }
            groupsMap.get(sorted).add(current);
        }
        groups.addAll(groupsMap.values());
        return groups;
    }

    private static List<List<String>> groupAnagramsBruteForce(String[] strs) {
        // Brute Force
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            // Check if current string belongs to any group
            boolean isAdded = false;
            for (int g = 0; g < groups.size(); g++) {
                if (areAnagrams(strs[i], groups.get(g).get(0))) {
                    isAdded = true;
                    groups.get(g).add(strs[i]);
                    break;
                }
            }
            if (!isAdded) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                groups.add(newGroup);
            }
        }
        return groups;
    }

    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)-'a']++;
            counts[str2.charAt(i)-'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) return false;
        }
        return true;
    }

}
