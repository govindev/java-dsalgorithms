package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;

public class MaxAppearingElementInRanges {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the arrays : ");
        int n = Integer.parseInt(input.readLine());
        System.out.println("Enter array 1 elements : ");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(input.readLine());
        }
        System.out.println("Enter array 2 elements : ");
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(input.readLine());
        }
        System.out.println("Maximum appeared element in the ranges is : " + findMaxAppearedElement(arr1, arr2));
        System.out.println("Maximum appeared element in the ranges is : " + findMaxAppearedElementEfficient(arr1, arr2));
    }

    private static int findMaxAppearedElementEfficient(int[] arr1, int[] arr2) {
        // If it is given the highest element in the range is below 1000 then this solution more efficient
        int[] prefixSum = new int[1000];
        for (int i = 0; i < arr1.length; i++) {
            prefixSum[arr1[i]] = 1;
            prefixSum[arr2[i]+1] = -1;
        }
        int maxSum = prefixSum[0], maxAppeared = 0;
        for(int i = 1; i < 1000; i++) {
            prefixSum[i] += prefixSum[i-1];
            if (maxSum < prefixSum[i]) {
                maxAppeared = i;
                maxSum = prefixSum[i];
            }
        }
        return maxAppeared;
    }


    private static int findMaxAppearedElement(int[] arr1, int[] arr2) {
        // This solution requires an extra space for the HashMap and time complexity for all the map operations
        Map<Integer, Integer> map = new HashMap<>();
        int maxAppeared = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int r = arr1[i]; r < arr2[i]; r++) {
                int count = 1;
                if (map.containsKey(r)) {
                    count += map.get(r);
                }
                map.put(r, count);
                maxAppeared = Math.max(map.get(maxAppeared), count);
            }
        }
        return maxAppeared;
    }
}
