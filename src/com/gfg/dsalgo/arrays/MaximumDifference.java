package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max difference is : " + maxDifference(array));
    }

    private static int maxDifference(int[] array) {
        int i = 0, j = 1;
        int maxDifference = array[j] - array[i];
        for(int p = 1; p < array.length; p++) {
            if (array[p] < array[i]) {
                i = p;
                j = i+1;
            }
            if (j < array.length && i != p && array[p] > array[j]) {
                j = p;
            }
            if (j < array.length) {
                maxDifference = Math.max(maxDifference,array[j] - array[i]);
            }
        }
        return maxDifference;
    }

    private static int maxDifferenceOptimum(int[] array) {
        int max = array[1] - array[0];
        int minValue = array[0];
        for (int j = 1; j < array.length; j++) {
            max = Math.max(max, array[j] - minValue);
            minValue = Math.min(minValue, array[j]);
        }
        return max;
    }

}
