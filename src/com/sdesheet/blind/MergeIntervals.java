package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        // Sort the intervals based on the first value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prevInterval = result.get(result.size() - 1);
            if (canMerge(prevInterval, intervals[i])) {
                int[] mergedInterval = merge(prevInterval, intervals[i]);
                result.remove(result.size() - 1);
                result.add(mergedInterval);
            } else {
                result.add(intervals[i]);
            }
        }


        return result.toArray(new int[result.size()][]);

    }

    private boolean canMerge(int[] first, int[] second) {
        return (first[1] >= second[0]);
    }

    private int[] merge(int[] first, int[] second) {
        int to = (first[1] > second[1]) ? first[1] : second[1];
        return new int[]{first[0], to};
    }
}
