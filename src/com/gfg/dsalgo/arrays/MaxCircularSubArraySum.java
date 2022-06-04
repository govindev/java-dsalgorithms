package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxCircularSubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max sum of the Circular subarray is : " + maxSubarraySumCircular(array));
    }

    private static int getMaxSubArraySum(int[] arr) {
        int max = arr[0], curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr+arr[i]);
            max = Math.max(curr, max);
        }
        return max;
    }

    private static int maxSubarraySumCircular(int[] arr) {
        int maxSubArrSum = getMaxSubArraySum(arr);
        if(maxSubArrSum < 0) {
            return maxSubArrSum;
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            arr[i] = -arr[i];
        }
        int maxCirSubArrSum = total + getMaxSubArraySum(arr);
        return Math.max(maxSubArrSum, maxCirSubArrSum);
    }
}
