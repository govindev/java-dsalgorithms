package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftRotateArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        array = leftRotateArrayBy1(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    private static int[] leftRotateArrayBy1(int[] array) {
        int left = array[0];
        int i = 0;
        for (; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        array[i] = left;
        return array;
    }

    private static int[] leftRotateArrayByN(int[] array, int d) {
        int left = array[0];
        int i = 0;
        for (; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        array[i] = left;
        return array;
    }
}
