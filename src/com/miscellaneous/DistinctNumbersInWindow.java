package com.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        List<Integer> A =  List.of(1, 2, 1, 3, 4, 3);
        int B = 3;
        dNums(A, B);
    }

    public static ArrayList<Integer> dNums(List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        for (right = 0; right < B; right++) {
            Integer val = A.get(right);
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(map.size());

        while (right < A.size()) {
            Integer val = A.get(right);
            map.put(val, map.getOrDefault(val, 0)+1);

            val = A.get(left);
            if (map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val)-1);
            }
            left++;
            res.add(map.size());

            right++;

        }

        return res;
    }
}
