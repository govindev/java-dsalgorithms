package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (canMerge(current, interval)) {
                current = merge(current, interval);
            } else {
                mergedIntervals.add(current);
                current = interval;
            }
        }
        mergedIntervals.add(current);
        int[][] res = new int[mergedIntervals.size()][2];
        return mergedIntervals.toArray(res);
    }

    private boolean canMerge(int[] a, int[] b) {
        if (b[0] >= a[0] && b[0] <= a[1]) {
            return true;
        }
        return false;
    }


    private int[] merge(int[] a, int[] b) {
        a[1] = Math.max(a[1], b[1]);
        return a;
    }
}
