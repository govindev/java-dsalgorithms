package com.gfg.dsalgo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindElementInInfiniteArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Etner the elements of the array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the element to be searched : ");
        int k = Integer.parseInt(br.readLine());
        System.out.println("Elements positions is : " + findPosition(arr, k));
    }

    private static int findPosition(int[] arr, int x) {
        // Thing here is we shouldn't be using the arr.length().
        // unbounded binary search
        if (arr[0] == x) return 0;
        int i = 1;
        while(arr[i] < x) {
            i *= 2;
        }
        if (arr[i] == x) return i;

        // Do the binary search
        int left = i/2+1, right = i;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == x) return mid;
            else if(x > arr[mid]) left = mid+1;
            else right = mid - 1;
        }
        return -1;
    }
}
