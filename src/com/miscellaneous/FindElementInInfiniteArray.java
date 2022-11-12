package com.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FindElementInInfiniteArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the array elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the element to be found : ");
        int element = Integer.parseInt(br.readLine());
        System.out.println("Element found at position : " + findElementPositionInArray(array, element));
    }

    private static int findElementPositionInArray(int[] array, int element) {
        int x = 1;
        while (array[x] < element) {
            x *= 2;
        }
        if (array[x] == element) return x;
        int left = x/2, right = x;
        while (left < right) {
            int mid = (left+right)/2;
            if (array[mid] == element) return mid+1;
            if (array[mid] < element) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
