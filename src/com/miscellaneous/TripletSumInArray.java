package com.miscellaneous;

import java.util.Arrays;

public class TripletSumInArray {
    public static boolean find3Numbers(int A[], int n, int X) {
        Arrays.sort(A);
        for (int i = 0; i < n-2; i++) {
            int left = i+1, right = n-1;
            while (left < right) {
                int sum = (A[i] + A[left] + A[right]);
                if (sum == X) return true;
                else if (sum > X) right--;
                else left++;
            }
        }
        return false;

    }
}
