package com.gfg.dsalgo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountOccurancesInArray {
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
        System.out.println("Number of times element appears is : " + countOccurances(arr, k));

    }
    private static int countOccurances(int[] nums, int target) {
        int last = findLastOccurance(nums,target);
        if (last == -1) return 0;
        int first = findFirstOccurance(nums, target);
        return (last - first) + 1;
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

    private static int findLastOccurance(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length-1 || nums[mid+1] != target) {
                    return mid;
                }
                left = mid+1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
