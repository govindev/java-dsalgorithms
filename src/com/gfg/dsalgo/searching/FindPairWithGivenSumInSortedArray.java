package com.gfg.dsalgo.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPairWithGivenSumInSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the array ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the sum to be found : ");
        int sum = Integer.parseInt(br.readLine());

        if (findPairWithSumInSortedArray(arr, sum)) {
            System.out.println("Find with the given sum is found");
        } else {
            System.out.println("There is no pair with the given sum");
        }
    }

    private static boolean findPairWithSumInSortedArray(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            if (arr[left]+arr[right] == sum) return true;
            else if (arr[left]+arr[right] > sum) right--;
            else left++;
        }
        return false;
    }

}
