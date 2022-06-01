package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        removeDuplicatesFromSortedArray(array);
    }

    private static void removeDuplicatesFromSortedArray(int[] array) {
        int size = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[size - 1]) {
                array[size] = array[i];
                size++;
            }
        }
        System.out.println("Unique array is : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ", ");
        }
    }

}
