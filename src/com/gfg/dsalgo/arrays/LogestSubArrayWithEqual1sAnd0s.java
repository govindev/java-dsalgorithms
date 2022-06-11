package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LogestSubArrayWithEqual1sAnd0s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the Array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        longestSubArrayWithEqual1sAnd0s(arr);
    }

    private static void longestSubArrayWithEqual1sAnd0s(int[] nums) {
        Map<Integer,Integer> counts = new HashMap<>();
        int count = 0, maxLength = 0;
        counts.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;
            if (counts.containsKey(count)) {
                maxLength = Math.max(maxLength, i - counts.get(count));
            } else {
                counts.put(count, i);
            }
        }
        System.out.println("Maximum sub array length with equal number of 1s and 0s is " + maxLength);
    }
}
