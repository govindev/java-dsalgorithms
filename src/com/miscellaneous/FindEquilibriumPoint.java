package com.miscellaneous;

public class FindEquilibriumPoint {
    String equilibrium(int arr[], int n) {
        // Find the total sum
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            int right = total-left-arr[i];
            if (left == right) return "YES";
            left += arr[i];
        }
        return "NO";
    }
}
