package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrequenciesInSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        printFrequencies(array);
    }

    private static void printFrequencies(int[] array) {
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) count++;
            else {
                System.out.println("Frequency of : " + array[i-1] + " is : " + count);
                count = 1;
            }
        }
        System.out.println("Frequency of : " + array[array.length-1] + " is : " + count);
    }

}
