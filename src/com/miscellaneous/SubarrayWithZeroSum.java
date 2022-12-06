package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (num == 0 || sum == 0 || sums.contains(sum)) return true;
            sums.add(sum);
        }
        return false;
    }
}
