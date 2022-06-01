package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SecondLargestInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Index of the second largest element in the array is : " + findIndexOfSecondLargestElement(array));
    }

    private static int findIndexOfSecondLargestElement(int[] array) {
        int largestElmInd = 0;
        int secondLargestElmInd = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largestElmInd]) {
                secondLargestElmInd = largestElmInd;
                largestElmInd = i;
            } else if(array[i] != array[largestElmInd]) {
                if (secondLargestElmInd == -1 || array[i] > array[secondLargestElmInd]) {
                    secondLargestElmInd = i;
                }
            }

        }
        return secondLargestElmInd;
    }
}
