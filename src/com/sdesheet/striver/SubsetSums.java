package com.sdesheet.striver;

import java.util.ArrayList;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < N; i++) {
            res.add(arr.get(i));
            res = subsetSums(arr, arr.get(i), i+1, res);
        }
        return res;
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int sum, int from, ArrayList<Integer> res) {
        for (int i = from; i < arr.size(); i++) {
            res.add(sum+arr.get(i));
            res = subsetSums(arr, sum+arr.get(i), i+1, res);
        }
        return res;
    }
}
