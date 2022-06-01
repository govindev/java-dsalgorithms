package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        array = reverseArray(array);

    }

    private static int[] reverseArray(int[] array) {
        int low = 0; int high = array.length - 1;
        while (low < high) {
            int temp = array[high];
            array[high] = array[low];
            array[low] = temp;
            low++;
            high--;
        }
        return array;
    }
}
