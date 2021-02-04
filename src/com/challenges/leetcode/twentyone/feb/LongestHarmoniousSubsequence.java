package com.challenges.leetcode.twentyone.feb;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		int longest = 0;
		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : nums) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}
		for (int i : counts.keySet()) {
			if (counts.containsKey(i + 1)) {
				longest = (longest > counts.get(i) + counts.get(i + 1)) ? longest : counts.get(i) + counts.get(i + 1);
			}
		}
		return longest;
	}
}
