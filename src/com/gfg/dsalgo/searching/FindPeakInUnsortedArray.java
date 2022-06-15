package com.gfg.dsalgo.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPeakInUnsortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the array ");
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Peak found at : " + findPeakElement(arr));
    }

    private static int findPeakElement1(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if ((mid == 0 || nums[mid-1] <= nums[mid]) &&
                    (mid == nums.length-1 || nums[mid+1] <= nums[mid])) {
                return mid;
            } else if (mid > 0 && nums[mid-1] > nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
