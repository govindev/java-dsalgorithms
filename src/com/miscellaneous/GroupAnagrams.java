package com.miscellaneous;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> group = anagrams.getOrDefault(key, new ArrayList<>());
            group.add(str);
            anagrams.put(key, group);
        }
        return new ArrayList<>(anagrams.values());
    }

    public String getKey(String str) {
        // With sorting
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
    public String getKeyWithoutSort(String str) {
        // Without sorting
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                sb.append(('a'+i));
            sb.append(count[i]);
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (set.contains(i)) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if (set.contains(j)) continue;
                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    set.add(j);
                }
            }
            res.add(group);
        }
        return res;
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] counts = new int['z'-'a'+1];
        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)-'a']++;
            counts[str2.charAt(i)-'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) return false;
        }
        return true;
    }
}
