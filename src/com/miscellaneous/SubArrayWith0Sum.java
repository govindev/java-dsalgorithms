package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWith0Sum {
    static boolean findsum(int arr[],int n)
    {
        // 0 4 6 3 4
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
