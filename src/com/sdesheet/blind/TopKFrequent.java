package com.sdesheet.blind;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequentUsingQueue(nums, k);
        // return topKFrequentOptimized(nums, k);
    }

    public int[] topKFrequentUsingQueue(int[] nums, int k) {

        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int num : nums) {
            int count = valueCountMap.getOrDefault(num, 0)+1;
            valueCountMap.put(num, count);
        }

        PriorityQueue<Integer> countOrderedValues = new PriorityQueue<>((a, b) -> valueCountMap.get(b) - valueCountMap.get(a));
        countOrderedValues.addAll(valueCountMap.keySet());

        int[] result = new int[k];
        int r = 0;
        while (!countOrderedValues.isEmpty()) {
            if (r >= k) {
                return result;
            }
            result[r++] = countOrderedValues.remove();
        }

        return result;
    }

    public int[] topKFrequentOptimized(int[] nums, int k) {
        int maxCount = 0;
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int num : nums) {
            int count = valueCountMap.getOrDefault(num, 0)+1;
            valueCountMap.put(num, count);
            maxCount = Math.max(count, maxCount);
        }

        List<Integer>[] countValues = new List[maxCount+1];
        for (int value : valueCountMap.keySet()) {
            int count = valueCountMap.get(value);
            List<Integer> values = countValues[count];
            if (values == null) {
                values = new ArrayList<>();
            }
            values.add(value);
            countValues[count] = values;
        }

        int[] result = new int[k];
        int r = 0;
        for (int i = maxCount; i > 0; i--) {
            List<Integer> values = countValues[i];
            if (values != null)
                for (int value: values) {
                    if (r >= k) return result;
                    result[r++] = value;
                }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 2);
    }
}
