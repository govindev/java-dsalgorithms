package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindEquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Equilibrium point is : " + findEquilibriumPoint(array));

        System.out.println("Equilibrium point is : " + findEquilibriumPointEfficient(array));
    }

    private static int findEquilibriumPointEfficient(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == sum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
            sum -= arr[i];
        }
        return -1;
    }

    private static int findEquilibriumPoint(int[] arr) {
        int[] sums = prefixSum(arr);
        if (0 == sums[arr.length-1] - arr[0]) return 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (sums[i-1] == (sums[arr.length-1] - sums[i])) {
                return i;
            }
        }
        if (0 == sums[arr.length-2]) return arr.length - 1;
        return -1;
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
