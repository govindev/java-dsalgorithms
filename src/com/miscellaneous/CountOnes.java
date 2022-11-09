package com.miscellaneous;

import java.io.IOException;

public class CountOnes {
    public static void main(String[] args) throws IOException {
        // Array is non-increasing / decreasing order
        int[] arr = new int[] {1, 1, 0, 0, 0, 0, 0};
        int lastOcc = findLastOccurance(arr, 1);
        System.out.println("Count of 1s is : " + (lastOcc+1));
    }

    private static int findLastOccurance(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == target) {
                if (mid == arr.length-1 || arr[mid] != arr[mid+1]) return mid;
                left = mid+1;
            }
            else if (arr[mid] > target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
