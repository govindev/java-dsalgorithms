package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogestSubArrayWithEqual1sAnd0s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the Array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        longestSubArrayWithEqual1sAnd0s(arr);
    }

    private static void longestSubArrayWithEqual1sAnd0s(int[] arr) {
        // TODO Below code doesn't work. Need to work on the logic
        int count0s = 0;
        int count1s = 0;
        int subArrayEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0s++;
            }
            if (arr[i] == 1) {
                count1s++;
            }
            if (count0s == count1s) {
                subArrayEnd = i;
            }
        }
        System.out.println("Maximum sub array with equal number of 1s and 0s starts at : 0 and ends at " + subArrayEnd);
    }
}
