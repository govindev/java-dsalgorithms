package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Check3DivisionsWithEqualSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the Array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (checkIfArrayHas3EqualSumDivisions(arr)) {
            System.out.println("Array has 3 divisions with equal sum");
        } else {
            System.out.println("Array doesn't has 3 divisions with equal sum");
        }
    }

    private static boolean checkIfArrayHas3EqualSumDivisions(int[] arr) {
        // Calculate the prefix sum
        int[] sums = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // If there are 3 divisions with equal sum
        // There exists a 1st division in the start of the array
        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            if (2*leftSum == rightSum) {
                // Check whether the right array has equal sums
                int secondSum = 0, thirdSum = 0;
                for (int j = i+1; j < arr.length - 1; j++) {
                    secondSum += arr[j];
                    if (secondSum == leftSum) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
