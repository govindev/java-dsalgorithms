package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[] {48, 24, 99, 51, 33, 39, 29, 83, 74, 72, 22, 46, 40, 51, 67, 37, 78, 76, 26, 28, 76, 25, 10, 65,
                64, 47, 34, 88, 26, 49, 86, 73, 73, 36, 75, 5, 26, 4, 39, 99, 27, 12, 97, 67, 63, 15, 3, 92, 90};
        int n = 49, k = 50;
        System.out.println("" + getPairsCount(arr, n, k));
    }
    static int getPairsCountTwoLoops(int[] arr, int n, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = counts.getOrDefault(arr[i], 0);
            counts.put(arr[i], ++count);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (counts.containsKey(k-arr[i])) {
                Integer currElmCnt = counts.get(arr[i]);
                if (currElmCnt == 1) counts.remove(arr[i]);
                else counts.put(arr[i], --currElmCnt);

                count += counts.getOrDefault(k-arr[i], 0);
            }

        }
        return count;
    }

    static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            if (counts.containsKey(k-num)) {
                count += counts.get(k-num);
            }
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }
        return count;
    }
}
