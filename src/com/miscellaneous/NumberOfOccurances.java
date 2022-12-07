package com.miscellaneous;

public class NumberOfOccurances {
    int count(int[] arr, int n, int x) {

        int left = 0, right = n-1;
        int firstOccurance = -1, lastOccurance = -1;

        // Find the last occurance
        while (left <= right) {
            int mid = (left+right)/2;

            if (arr[mid] == x) {
                if (mid == n-1 || arr[mid+1] != x) {
                    lastOccurance = mid;
                    break;
                } else {
                    left = mid+1;
                }
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (lastOccurance == -1) return 0;

        // Find the first occurance
        left = 0; right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;

            if (arr[mid] == x) {
                if (mid == 0 || arr[mid-1] != x) {
                    firstOccurance = mid;
                    break;
                } else {
                    right = mid-1;
                }
            } else if (arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }


        return 1 + (lastOccurance - firstOccurance);

    }
}
