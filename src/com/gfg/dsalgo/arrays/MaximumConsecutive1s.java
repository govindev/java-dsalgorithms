package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumConsecutive1s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max consecutive 1s are : " + getMaxConsecutive1s(array));
    }


    private static int getMaxConsecutive1s(int[] arr) {
        int max = 0, curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                curr = 0;
                continue;
            }
            curr++;
            max = Math.max(curr, max);
        }
        return max;
    }
}
