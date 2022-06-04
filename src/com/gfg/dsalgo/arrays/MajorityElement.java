package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MajorityElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Majority element's index is : " + majorityElementIndex(array));
    }

    private static int findPossibleMajorityElementIndex(int[] arr) {
        int ind = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[ind]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ind = i; count = 1;
            }
        }
        return ind;
    }

    private static int majorityElementIndex(int[] arr) {
        // This uses Moore's voting algorithm
        int ind = findPossibleMajorityElementIndex(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[ind]) {
                count++;
                if (count > arr.length / 2) {
                    return ind;
                }
            }
        }
        return -1;
    }


    private static int majorityElementIndexNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    if (count > arr.length/2) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
