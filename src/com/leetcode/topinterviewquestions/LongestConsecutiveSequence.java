package com.leetcode.topinterviewquestions;

import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		// This works in O(N) time complexity and O(N) space complexity
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int maxCount = 0;
		for (int num : set) {
			if (set.contains(num - 1)) {
				continue;
			} else {
				// This is the minimum number in the sequence
				int count = 1;
				while (set.contains(num + 1)) {
					count++;
					num++;
				}
				maxCount = (count > maxCount) ? count : maxCount;
			}
		}
		return maxCount;
	}

	public int longestConsecutiveNaive(int[] nums) {
		// This works in time complexity of O(NlogN) for initial sorting and O(N) for
		// count traversal
		Set<Integer> set = new TreeSet<>();
		for (int num : nums) {
			set.add(num);
		}
		for (int num : set) {
			System.out.print(num + ", ");
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
