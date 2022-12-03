package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountNumberOfSubArraysWithGivenXOR {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0, xor = 0;

        Iterator<Integer> iterator = A.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();

            xor = xor ^ val;
            if (xor == B) {
                count++;
            }

            count += freq.getOrDefault(xor ^ B, 0);

            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
