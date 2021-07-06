package com.leetcode.topinterviewquestions;

import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groups = new HashMap<>();
		for (String str : strs) {
			char chArr[] = str.toCharArray();
			Arrays.sort(chArr);
			String key = new String(chArr);
			if (groups.containsKey(key)) {
				List<String> group = groups.get(key);
				group.add(str);
				groups.put(key, group);
			} else {
				List<String> group = new ArrayList<>();
				group.add(str);
				groups.put(key, group);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (List<String> group : groups.values()) {
			result.add(group);
		}
		return result;
	}
}
