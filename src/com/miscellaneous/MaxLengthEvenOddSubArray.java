package com.miscellaneous;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 7, 9} ;
        System.out.println(maxLengthEvenOddSubArray(arr));
    }

    private static int maxLengthEvenOddSubArray(int[] arr) {
        if (arr.length < 2) return 0;
        int maxLength = 0;
        int left = 0, right = 1;
        while (right < arr.length) {
            if (left != right-1) maxLength = Math.max(maxLength, (right-left));
            if (arr[right]%2 == arr[right-1]%2) {
                left = right;
            }
            right++;
        }
        return maxLength;
    }
}
