package com.miscellaneous;

public class CountZeros {
    int countZeroes(int[] arr, int n) {
        // Do a Binary search and find the first index of 0
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (arr[mid] == 0) {
                if (mid == 0 || arr[mid-1] == 1) return n-mid;
                right = mid-1;
            } else if (arr[mid] == 1) {
                left = mid+1;
            }
        }
        return 0;
    }
}
