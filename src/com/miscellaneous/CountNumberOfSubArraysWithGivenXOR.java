package com.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubArraysWithGivenXOR {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0, xorr = 0;

        for (int num : A) {
            xorr = xorr ^ num;
            if (xorr == B) count++;
            count += freq.getOrDefault(xorr ^ B, 0);
            freq.put(xorr, freq.getOrDefault(xorr, 0)+1);
        }
        return count;
    }
}
