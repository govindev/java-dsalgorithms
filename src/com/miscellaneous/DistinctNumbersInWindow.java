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
        Map<Integer, Integer> counts = new HashMap<>();
        ArrayList<Integer> windowCounts = new ArrayList<>();
        int start = 0, end = 0;
        while (start <= end && end < A.size()) {
            int windowLength = (end-start) + 1;
            if (windowLength <= B) {
                int endNum = A.get(end);
                counts.put(endNum, counts.getOrDefault(endNum,0)+1);
                end++;

                if (windowLength == B) windowCounts.add(counts.size());
            } else if (windowLength > B) {
                // Remove the left
                int startNum = A.get(start);
                int startCount = counts.getOrDefault(startNum, 0);
                if (startCount == 1) counts.remove(startNum);
                else counts.put(startNum, startCount-1);
                start++;
            }
        }
        return windowCounts;
    }

    public static ArrayList<Integer> dNums1(List<Integer> A, int B) {
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
