package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinGroupFlips {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        // printMinGroupFlipsNaive(array);
        // printMinGroupFlipsEfficient(array);
        privateMinGroupEfficientAndRefactored(array);
    }

    private static void privateMinGroupEfficientAndRefactored(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                if (arr[i] != arr[0]) {
                    // Start of the Group
                    System.out.print("Flip from : " + i + ", To : ");
                } else {
                    System.out.println(i-1);
                }
            }
        }
        if (arr[arr.length-1] != arr[0]) {
            System.out.println(arr.length - 1);
        }
    }

    private static void printMinGroupFlipsEfficient(int[] arr) {
        // Idea is the second group always has either less or equal groups compared to the first group
        int i = 1;
        while(arr[0] == arr[i] && i < arr.length) {
            i++;
        }
        if (i == arr.length) {
            return;
        }
        int minGroupNum = arr[i];
        int start = i;
        int flipCount = 1;
        for (; i < arr.length; i++) {
            if (arr[i] != minGroupNum) {
                if (start > -1) {
                    System.out.println("Flip from : " + start + ", to : " + (i-1));
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                    flipCount++;
                }
            }
        }
        System.out.println("Min number of flips required  are : " + flipCount);
    }

    private static void printMinGroupFlipsNaive(int[] arr) {
        int flipZeroCount = 0, flipOneCount = 0;

        int start = -1;
        StringBuilder flipZeroStr = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (start == -1) {
                    start = i;
                    flipZeroCount++;
                }
            } else {
                if (start > -1) {
                    flipZeroStr.append("Flip from : " + start + ", To : " + (i-1) + "\n");
                    start = -1;
                }
            }
        }

        start = -1;
        StringBuilder flipOneStr = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (start == -1) {
                    start = i;
                    flipOneCount++;
                }
            } else {
                if (start > -1) {
                    flipOneStr.append("Flip from: " + start + ", To : " + (i-1) + "\n");
                    start = -1;
                }
            }
        }
        if (flipOneCount+flipZeroCount > 1) {
            // Only if you at-least one group of 1's and one group of 0's.
            // Else we don't need to flip as the elements are already same
            System.out.println("Minimum number of flips required are : " + Math.min(flipOneCount, flipZeroCount));
            System.out.println((flipOneCount > flipZeroCount) ? flipZeroStr.toString() : flipOneStr.toString());
        }
    }
}
