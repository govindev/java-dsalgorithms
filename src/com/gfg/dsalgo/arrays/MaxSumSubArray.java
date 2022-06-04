package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max sum of the subarray is : " + getMaxSumSubArray(array));
    }

    private static int getMaxSumSubArray(int[] arr) {
        int sum = 0, maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum+arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
