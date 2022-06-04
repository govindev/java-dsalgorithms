package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NbonaciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter N : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter M (Number of elements to be printed) : ");
        int m = Integer.parseInt(br.readLine());
        printNbonaicNumbers(n, m);
    }

    private static void printNbonaicNumbers(int n, int m) {
        int arr[] = new int[m];
        int i = 0;
        // First n-1 elements are going to be 0's
        for (; i < n-1; i++) {
           arr[i] = 0;
        }
        arr[i] = 1;
        int sum = 1;
        i++;

        for (; i < m; i++) {
            arr[i] = sum;
            sum = sum + arr[i] - arr[i-n];
        }

        // Print
        for (int elm : arr) {
            System.out.print(elm + ", ");
        }
    }
}
