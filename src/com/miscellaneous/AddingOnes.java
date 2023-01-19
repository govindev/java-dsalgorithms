package com.miscellaneous;

public class AddingOnes {
    public static void updateNaive(int a[], int n, int updates[], int k)
    {
        for (int j : updates) {
            for (int i = j-1; i < n; i++) {
                a[i]++;
            }
        }
    }

    public static void update(int a[], int n, int updates[], int k)
    {
        for (int j : updates) {
            a[j-1]++;
        }
        for (int i = 1; i < n; i++) {
            a[i] += a[i-1];
        }
    }
}
