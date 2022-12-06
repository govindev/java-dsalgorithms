package com.miscellaneous;

public class CountTheZeros {
    int countZeroes(int[] arr, int n) {
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == 1) {
                left = mid+1;
            } else if (mid == 0 || arr[mid-1] == 1) {
                return (n-mid);
            } else {
                right = mid-1;
            }
        }
        return 0;
    }
}
