package com.miscellaneous;

import java.util.Arrays;

public class MaxOccuredInteger {
    public static int maxOccured(int L[], int R[], int n, int maxx){

        int[] counts = new int[maxx+1];
        for (int i = 0; i < n; i++) {
            for (int r = L[i]; r <= R[i]; r++) {
                counts[r]++;
            }
        }

        int maxOccured = 0, maxOccurances = 0;
        for (int i = 0; i <= maxx; i++) {
            if (counts[i] > maxOccurances) {
                maxOccurances = counts[i];
                maxOccured = i;
            }
        }
        return maxOccured;
    }


    //Function to find the maximum occurred integer in all ranges.
    public static int maxOccured1(int L[], int R[], int n, int maxx){
        int maxOccured = Integer.MAX_VALUE, maxOccurances = Integer.MIN_VALUE;

        int[] occurances = new int[maxx+1];
        Arrays.fill(occurances, 0);

        for (int i = 0; i < L.length; i++) {
            int curr = L[i], end = R[i];
            while (curr <= end) {
                occurances[curr]++;
                if (occurances[curr] >= maxOccurances) {
                    maxOccured = (occurances[curr] == maxOccurances) ? Math.min(maxOccured, curr) : curr;
                    maxOccurances = occurances[curr];
                }
                curr++;
            }
        }
        return maxOccured;
    }
}
