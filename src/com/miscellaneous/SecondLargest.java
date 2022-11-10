package com.miscellaneous;

public class SecondLargest {
    int print2largest(int arr[], int n) {
        int largest = -1;
        int largest2 = largest;
        for (int val : arr) {
            if (val > largest) {
                largest2 = largest;
                largest = val;
            } else if (val != largest) {
                largest2 = Math.max(largest2, val);
            }
        }
        return largest2;
    }
}
