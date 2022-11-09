package com.miscellaneous;

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
}
