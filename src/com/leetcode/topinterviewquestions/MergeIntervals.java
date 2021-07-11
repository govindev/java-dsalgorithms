package com.leetcode.topinterviewquestions;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
		// };
		int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
		merge(intervals);
	}

	public static int[][] merge(int[][] intervals) {
		List<Integer[]> ints = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			ints.add(new Integer[] { intervals[i][0], intervals[i][1] });
		}
		boolean isOverlap = true;
		while (isOverlap) {
			isOverlap = false;
			for (int i = 0; i < ints.size() - 1; i++) {
				for (int j = i + 1; j < ints.size(); j++) {
					Integer[] overlap = findOverlap(ints.get(i), ints.get(j));
					if (overlap != null) {
						isOverlap = true;
						ints.remove(i);
						ints.add(i, overlap);
						ints.remove(j);
					}
				}
			}
		}

		int[][] output = new int[ints.size()][2];
		for (int i = 0; i < ints.size(); i++) {
			output[i] = new int[] { ints.get(i)[0], ints.get(i)[1] };
		}
		return output;
	}

	public static Integer[] findOverlap(Integer[] interval1, Integer[] interval2) {
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
			return new Integer[] { start1, (end2 > end1) ? end2 : end1 };
		}
		if (end1 == end2) {
			// Ends Match
			return new Integer[] { (start1 < start2) ? start1 : start2, end2 };
		}
		if ((end1 == start2) || (end2 == start1) || (start1 > start2 && start1 < end2)
				|| (start2 > start1 && start2 < end1) || (end1 > start2 && end1 < end2)
				|| (end2 > start1 && end2 < end1)) {
			return new Integer[] { (start1 < start2) ? start1 : start2, (end2 > end1) ? end2 : end1 };
		}
		return null;
	}
}
