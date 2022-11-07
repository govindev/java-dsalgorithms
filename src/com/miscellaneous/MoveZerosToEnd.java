package com.miscellaneous;

public class MoveZerosToEnd {
    void pushZerosToEnd(int[] arr, int n) {
        int left = 0, right = 1;
        while (right < n) {
            if (arr[left] > 0) {
                left++;
                if (right <= left)
                    right = left+1;
                continue;
            }
            if (arr[right] == 0) {
                right++;
                continue;
            }
            arr[left] = arr[right];
            arr[right] = 0;
        }
    }
}
