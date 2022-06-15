package com.gfg.dsalgo.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum {
    public static boolean find3Numbers(int A[], int n, int X) {
        // Sort and Two-pointer approach
        Arrays.sort(A);
        for (int i = 0; i < n-2; i++) {
            int sum = X-A[i];
            int left = i+1, right = n-1;
            while (left < right) {
                int curr = A[left]+A[right];
                if (curr == sum) return true;
                if (curr > sum) right--;
                else left++;
            }
        }
        return false;
    }

    public static boolean find3NumbersHash(int A[], int n, int X) {
        // Hashing approach
        for (int i = 0; i < n-2; i++) {
            if(find2Numbers(A, n, X-A[i], i+1)) return true;
        }
        return false;
    }

    private static boolean find2Numbers(int A[], int n, int X, int start) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (set.contains(X - A[i])) {
                return true;
            }
            set.add(A[i]);
        }
        return false;
    }
}
