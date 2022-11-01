package com.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountOnes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length of the array: ");
        int length = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the array : ");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Count of 1s is : " + countOnes(arr));
    }

    private static int countOnes(int[] arr) {
        if (arr[0] == 0) return 0;
        // Find the last occurance of the 1
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == 0) {
                end = mid - 1;
                continue;
            }
            if (arr[mid+1] == 0) {
                return mid+1;
            }
            start = mid+1;
        }
        return start+1;
    }
}
