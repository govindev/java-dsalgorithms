package com.miscellaneous;

public class FindMaxSumKElements {
    long maxSubarraySum(int arr[], int n){

        long curr = arr[0], max = curr;
        for (int i = 1; i < n; i++) {
            curr = Math.max(curr+arr[i], arr[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}
