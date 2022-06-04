package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMaxSumKElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter K : ");
        int k = Integer.parseInt(br.readLine());
        System.out.println("Maximum sum of " + k + " consequtive elements is : " + findMaxSumKElements(array, k));
    }

    private static int findMaxSumKElements(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k-1) {
                max = Math.max(sum, max);
                sum -= arr[i-(k-1)];
            }
        }
        return max;
    }
}
