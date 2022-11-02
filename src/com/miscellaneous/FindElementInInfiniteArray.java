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
        if (element == array[0]) return 1;
        int i = 1;
        while (array[i] < element) {
            i *= 2;
        }

        int low = i/2, high = i;
        while (low < high) {
            int mid = (low+high)/2;
            if (array[mid] == element) {
                return mid+1;
            } else if (array[mid] > element) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
