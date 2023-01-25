package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < N; i++) {
            res.add(arr.get(i));
            res = subsetSums(arr, arr.get(i), i+1, res);
        }
        // return res;


        // Method2
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int sum, int from, ArrayList<Integer> res) {
        for (int i = from; i < arr.size(); i++) {
            res.add(sum+arr.get(i));
            res = subsetSums(arr, sum+arr.get(i), i+1, res);
        }
        return res;
    }

    // Method2
    void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        // Pick the element
        func(ind+1, sum+arr.get(ind), arr, N, sumSubset);

        // Do not pick the element
        func(ind+1, sum, arr, N, sumSubset);
    }
}
