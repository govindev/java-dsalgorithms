package com.gfg.dsalgo.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BinarySearch {
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
        System.out.println("Element found at : " + binarySearch(arr, k));
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
