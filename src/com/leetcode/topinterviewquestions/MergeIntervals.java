package com.leetcode.topinterviewquestions;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
		// };
		int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
		mergeNaive(intervals);
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		List<int[]> result = new ArrayList<>();
		for (int[] interval : intervals) {
			// if list is empty or does not overlap with the previous, just append
			if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
				result.add(interval);
			} else {
				// if overlap, merge the current and previous intervals
				result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static int[][] mergeNaive(int[][] intervals) {
		if (intervals == null || intervals.length == 1) {
			return intervals;
		}
		List<int[]> ints = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			ints.add(intervals[i]);
		}
		boolean isOverlap = true;
		while (isOverlap) {
			isOverlap = false;
			for (int i = 0; i < ints.size() - 1; i++) {
				for (int j = i + 1; j < ints.size(); j++) {
					int[] overlap = findOverlap(ints.get(i), ints.get(j));
					if (overlap != null) {
						isOverlap = true;
						ints.remove(i);
						ints.add(i, overlap);
						ints.remove(j);
					}
				}
			}
		}

		return ints.toArray(new int[0][]);
	}

	public static int[] findOverlap(int[] interval1, int[] interval2) {
		int start1 = interval1[0];
		int end1 = interval1[1];
		int start2 = interval2[0];
		int end2 = interval2[1];
		if (start1 == start2 && end1 == end2) {
			// Exact match
			return interval1;
		}
		if (start1 == start2) {
			// Stars Match
			return new int[] { start1, (end2 > end1) ? end2 : end1 };
		}
		if (end1 == end2) {
			// Ends Match
			return new int[] { (start1 < start2) ? start1 : start2, end2 };
		}
		if ((end1 == start2) || (end2 == start1) || (start1 > start2 && start1 < end2)
				|| (start2 > start1 && start2 < end1) || (end1 > start2 && end1 < end2)
				|| (end2 > start1 && end2 < end1)) {
			return new int[] { (start1 < start2) ? start1 : start2, (end2 > end1) ? end2 : end1 };
		}
		return null;
	}
}
