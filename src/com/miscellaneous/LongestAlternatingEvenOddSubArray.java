package com.miscellaneous;

public class LongestAlternatingEvenOddSubArray {
    public static void main(String[] args) {
        int arr[] = {1, 1,2,3,4,5,7,9};
        System.out.println(longestEvenOddSubArray(arr));
    }

    public static int longestEvenOddSubArray(int[] arr) {
        int longest = 1, curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]%2 == arr[i-1]%2) {
                curr = 1;
            } else {
                curr++;
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}
