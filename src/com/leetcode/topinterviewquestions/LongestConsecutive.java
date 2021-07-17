package com.leetcode.topinterviewquestions;

import java.util.*;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		// Set<Integer> set = new TreeSet<>();
		// for(int num : nums) {
		// set.add(num);
		// }
		List<Integer> set = new ArrayList<>();
		for (int num : nums) {
			set.add(num);
		}
		Collections.sort(set);
		for (int num : set) {
			System.out.println(num);
		}
		Integer prev = null;
		int count = 0;
		int maxCount = 0;
		for (Integer curr : set) {
			prev = (prev == null) ? curr : prev;
			if (prev == curr || prev + 1 == curr) {
				count++;
				maxCount = (count > maxCount) ? count : maxCount;
			} else {
				count = 0;
			}
			prev = curr;
		}
		return maxCount;
	}
}