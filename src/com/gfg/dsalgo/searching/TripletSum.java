package com.gfg.dsalgo.searching;

import java.util.*;

public class TripletSum {
    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) {
        // return find3NumbersUsingSorting(A, n, X);
        // return find3NumbersUsingHashing(A, n, X);
        return find3NumbersHash(A, n, X);
    }

    public static boolean find3NumbersUsingSorting(int A[], int n, int X) {

        // Your code Here
        Arrays.sort(A);
        // [1 4 6 8 10 45]
        for (int i = 0; i < n-2; i++) {
            int left = i+1, right=n-1;
            while(left < right) {
                int sum = A[i]+A[left]+A[right];
                if (sum == X) return true;
                if (sum > X) right--;
                else left++;
            }
        }
        return false;
    }

    public static boolean find3NumbersUsingHashing(int A[], int n, int X) {
        // Using Hashing
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer count = map.get(A[i]);
            map.put(A[i], count == null ? 1 : count++);
        }
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int s = X-A[i]-A[j];
                if (map.containsKey(s)) {
                    Integer count = map.get(s);
                    if (s == A[i]) count--;
                    if (s == A[j]) count--;
                    if (count == 1) return true;
                }
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

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int n = 6, X = 9;
        System.out.println("Found : " + find3Numbers(arr, n, X));
    }
}
