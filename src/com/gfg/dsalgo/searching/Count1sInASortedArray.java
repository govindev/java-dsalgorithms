package com.gfg.dsalgo.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count1sInASortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Etner the elements of the array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int firstOccuranceOf1 = findFirstOccurance(arr,1);
        if (firstOccuranceOf1 > -1) {
            System.out.println("Number of occurances of 1 are : " + (arr.length - firstOccuranceOf1));
        }
        System.out.println("Found no occurances of 1");

    }
    private static int findFirstOccurance(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                }
                right = mid-1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
