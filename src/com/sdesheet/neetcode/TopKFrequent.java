package com.sdesheet.neetcode;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // Using Priority Queue
        Map<Integer, Integer> map = new HashMap<>();
        for (int elm : nums) {
            map.put(elm, map.getOrDefault(elm, 0)+1);
        }

        /* Priority Queue which is used as Max Heap */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (Integer key : map.keySet()) {
            pq.offer(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public int[] topKFrequentUsingArrays(int[] nums, int k) {
        // Linear time approach.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
            }
            map.put(nums[i], count);
        }

        List<Integer>[] counts = new ArrayList[nums.length+1];
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            List<Integer> keys = counts[value];
            if (keys == null) {
                keys = new ArrayList<>();
            }
            keys.add(key);
            counts[value] = keys;
        }

        int[] res = new int[k];
        int ind = 0;
        for (int i = counts.length-1; i > 0; i--) {
            if (counts[i] != null) {
                for (Integer key : counts[i]) {
                    res[ind] = key.intValue();
                    ind++;
                    if (ind == k) return res;
                }
            }
        }
        return res;
    }
}
