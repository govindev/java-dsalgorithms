package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        Arrays.stream(nums).forEach(num -> counts.put(num, counts.getOrDefault(num, 0) + 1));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        counts.keySet().forEach(queue::offer);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
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
