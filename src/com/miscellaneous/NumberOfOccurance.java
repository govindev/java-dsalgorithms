package com.miscellaneous;

public class NumberOfOccurance {
    int count(int[] arr, int n, int x) {
        // Find the first occurance
        int left = 0, right = n-1, firstOccurance = -1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                if (mid == 0 || arr[mid-1] != x) firstOccurance = mid;
                right = mid-1;
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (firstOccurance == -1) return 0;
        // Find the last occurance
        left = 0; right = n-1;
        int lastOccurance = firstOccurance;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == x) {
                if (mid == n-1 || arr[mid+1] != x) lastOccurance = mid;
                left = mid+1;
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return lastOccurance - firstOccurance + 1;
    }
}
