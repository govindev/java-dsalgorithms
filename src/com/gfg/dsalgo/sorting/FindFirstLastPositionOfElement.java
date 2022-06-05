package com.gfg.dsalgo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindFirstLastPositionOfElement {
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
        System.out.println("Search range is : ");
        Arrays.stream(searchRange(arr, k)).forEach(value -> System.out.print(value + " "));
    }
    private static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (target == nums[mid]) {
                // todo
                int first = mid;
                int last = mid;
                while (first-1 > -1 && nums[first-1] == target) {first--;}
                while (last+1 < nums.length && nums[last+1] == target) {last++;}

                return new int[]{first, last};
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1,-1};
    }
}
