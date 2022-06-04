package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Check0SumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the Array : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements of the Array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(is0SumSubArrayFound(arr)) {
            System.out.println("There is a sub arrary with 0 sum");
        } else {
            System.out.println("There is no sub array with 0 sum");
        }
    }

    private static boolean is0SumSubArrayFound(int[] arr) {
       int sum = 0;
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i < arr.length; i++) {
           sum += arr[i];
           if (arr[i] == 0 || sum == 0 || set.contains(sum)) {
               return true;
           }
           set.add(sum);
       }
       return false;
    }

}
