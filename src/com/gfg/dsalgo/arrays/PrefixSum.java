package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        int[] sums = prefixSum(array);
        System.out.println("To get the sub array sum : Enter start : ");
        int start = Integer.parseInt(br.readLine());
        System.out.println("Enter end : ");
        int end = Integer.parseInt(br.readLine());
        if (start == 0) {
            System.out.println("Sum of sub array which starts at : " + start + " and ends at : " + end + " is : " + sums[end]);
        } else {
            System.out.println("Sum of sub array which starts at : " + start + " and ends at : " + end + " is : " + (sums[end] - sums[start-1]));
        }

    }

    private static int[] prefixSum(int[] arr) {
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sums[i] = sums[i-1] + arr[i];
        }
        Arrays.stream(sums).forEach(value -> System.out.print(value + ","));
        return sums;
    }
}
