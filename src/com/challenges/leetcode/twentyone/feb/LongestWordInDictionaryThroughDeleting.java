package com.challenges.leetcode.twentyone.feb;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

/***
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3649/
 * 
 * Longest Word in Dictionary through deleting
 * 
 * @author Govind
 *
 */

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			if (counts.containsKey(key)) {
				counts.put(key, counts.get(key) + 1);
			} else {
				counts.put(key, 1);
			}
		}
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).length() < longest.length()
					|| (d.get(i).length() >= longest.length() && d.get(i).compareTo(longest) > 0)) {
				continue;
			} else {
				Map<Character, Integer> cts = new HashMap<Character, Integer>();
				Boolean isValidSubstr = true;
				for (int j = 0; j < d.get(i).length(); j++) {
					if (!counts.containsKey(d.get(i).charAt(j))) {
						isValidSubstr = false;
						break;
					}
					int maxCount = counts.get(d.get(i).charAt(j));
					int count = 1;
					if (cts.containsKey(d.get(i).charAt(j))) {
						count += cts.get(d.get(i));
					}
					if (count > maxCount) {
						isValidSubstr = false;
						break;
					}
				}
				if (isValidSubstr) {
					longest = d.get(i);
				}
			}
		}
		return longest;
	}
}
