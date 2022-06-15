package com.gfg.dsalgo.searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the array ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the element to be searched ");
        int k = Integer.parseInt(br.readLine());
        System.out.println("Element found at : " + binarySearch(arr, k));
    }

    private static int binarySearch(int[] nums, int target) {
        // Find the smallest element / greatest element in the array
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            if (nums[low] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
