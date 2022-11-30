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

    private static int mergeSortAndCount(long[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left+right)/2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid+1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(long[] arr, int left, int mid, int right) {
        long[] leftArr = Arrays.copyOfRange(arr, left, mid+1);
        long[] rightArr = Arrays.copyOfRange(arr, mid+1, right+1);

        int i = 0, j = 0, k = left;
        int swaps = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid+1) - (left+i);
            }
        }
        while (i < leftArr.length)
            arr[k++] = leftArr[i++];
        while (j < rightArr.length)
            arr[k++] = rightArr[j++];

        return swaps;
    }
}
