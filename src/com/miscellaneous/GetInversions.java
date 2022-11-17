package com.miscellaneous;

import java.util.Arrays;

public class GetInversions {
    public static void main(String[] args) {
        long[] arr = new long[]{52244275, 123047899, 493394237, 922363607, 378906890, 188674257, 222477309, 902683641, 860884025, 339100162};

        System.out.println(getInversions(arr, arr.length));
    }
    public static long getInversions(long arr[], int n) {
        return mergeSortAndCount(arr, 0, n-1);
    }

    static long mergeSortAndCount(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int m = (l+r)/2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m+1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    static long mergeAndCount(long[] arr, int l, int m, int r) {
        long[] left = Arrays.copyOfRange(arr, l, m+1);
        long[] right = Arrays.copyOfRange(arr, m+1, r+1);

        int i = 0, j = 0, k = l;
        long swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m+1) - (l+i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }
}
