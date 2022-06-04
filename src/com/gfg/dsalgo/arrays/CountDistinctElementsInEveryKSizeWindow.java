package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class CountDistinctElementsInEveryKSizeWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter Window size : ");
        int k = Integer.parseInt(br.readLine());
        printDistinctElemtnsCountInWindow(array, k);

        // This particular problem uses both the sliding window technique and also hashing
    }

    private static void printDistinctElemtnsCountInWindow(Integer[] arr, int k) {
        System.out.print("Count of distinct elements of k different window sizes are : [");
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int count = 1;
            if (counter.containsKey(arr[i])) {
                count = counter.get(arr[i]);
                count++;
            }
            counter.put(arr[i], count);
        }
        System.out.print(counter.size() + ", ");
        for (int i = k; i < arr.length; i++) {
            int removeElm = arr[i-k];
            Integer count = counter.get(removeElm);
            if (count != null) {
                if (count == 1) {
                    counter.remove(removeElm);
                } else {
                    count--;
                    counter.put(removeElm, count);
                }
            }
            count = 1;
            if (counter.containsKey(arr[i])) {
                count = counter.get(arr[i]);
                count++;
            }
            counter.put(arr[i], count);
            System.out.print(counter.size() + ", ");
        }
        System.out.println("]");
    }
}
