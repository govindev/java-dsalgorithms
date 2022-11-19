package com.miscellaneous;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<String>());
            }
            anagrams.get(sorted).add(strs[i]);
        }
        res.addAll(anagrams.values());
        return res;
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
