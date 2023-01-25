package com.miscellaneous;

import java.util.Arrays;

public class GetInversions {
    public static void main(String[] args) {
        long[] arr = new long[]{52244275, 123047899, 493394237, 922363607, 378906890, 188674257, 222477309, 902683641, 860884025, 339100162};

        System.out.println(getInversions(arr, arr.length));
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSort(arr, 0, n-1);
    }

    public static long mergeSort(long[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        long count = mergeSort(arr, left, mid);
        count += mergeSort(arr, mid+1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    public static long merge(long[] arr, int left, int mid, int right) {
        long count = 0;
        long[] leftArr = Arrays.copyOfRange(arr, left, mid+1);
        long[] rightArr = Arrays.copyOfRange(arr, mid+1, right+1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += (mid+1) - (left+i);
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return count;
    }
}
