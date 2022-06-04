package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max length of the Even odd subarray is : " + getMaxLengthEvenOddSubArray(array));
    }

    private static int getMaxLengthEvenOddSubArray(int[] arr) {
        int max = 1;
        int curr = 1;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i-1] % 2 != arr[i] % 2) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

}
