package com.miscellaneous;

public class MoveZerosToEnd {
    void pushZerosToEnd(int[] arr, int n) {
        int newInd = 0, ind = 0;
        while (ind < n && newInd < n) {
            if (arr[newInd] != 0) {
                ind++; newInd++;
            } else if (arr[ind] != 0) {
                // Swap
                arr[newInd] = arr[ind];
                arr[ind] = 0;
                ind++; newInd++;
            } else {
                ind++;
            }
        }
    }
}
