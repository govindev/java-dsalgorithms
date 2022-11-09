package com.gfg.dsalgo.arrays;

public class AddingOnes {
    public static void update(int a[], int n, int updates[], int k)
    {
        for (int start : updates) {
            a[start-1]++;
            // for (int i = start-1; i < n; i++) {
            //     a[i]++;
            // }
        }
        for (int i = 1; i < n; i++) {
            a[i] += a[i-1];
        }
    }
}
