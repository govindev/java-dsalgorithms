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
//        array = leftRotateArrayBy1(array);
//        array = leftRotateArrayByN(array, 2);
//        array = leftRotateArrayByNAuxSpace(array, 2);
        array = leftRotateArrayByNOptimum(array, 2);

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
        // By left rotating 1 by d times
        for (int i = 0; i < d; i++) {
            array = leftRotateArrayBy1(array);
        }
        return array;
    }

    private static int[] leftRotateArrayByNAuxSpace(int[] array, int d) {
        // By having a temporary array to hold d elements
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = array[i];
        }
        int ind = 0;
        for (int i = d; i < array.length; i++) {
            array[ind] = array[i];
            ind++;
        }
        for (int i = 0; i < d; i++) {
            array[ind] = temp[i];
            ind++;
        }
        return array;
    }


    private static int[] reverse(int[] array, int start, int end) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

    private static int[] leftRotateArrayByNOptimum(int[] array, int d) {
        // Algorithm
        // 1. reverse first d elements
        // 2. reverse remaining elements in the array
        // 3. reverse the total array
        array = reverse(array, 0, d-1);
        array = reverse(array, d, array.length-1);
        return reverse(array, 0, array.length-1);
    }
}
