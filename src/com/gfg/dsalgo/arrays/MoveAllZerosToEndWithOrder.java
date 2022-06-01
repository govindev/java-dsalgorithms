package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveAllZerosToEndWithOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        array = moveAllZerosUsingCount(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    private static int[] moveAllZeros(int[] array) {
        int ptr = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[ptr] = array[i];
                ptr++;
            }
        }
        for(int i = ptr; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }


    private static int[] moveAllZerosUsingCount(int[] array) {
        int countOfNonZeros = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[countOfNonZeros];
                array[countOfNonZeros] = array[i];
                array[i] = temp;
                countOfNonZeros++;
            }
        }
        return array;
    }

}
