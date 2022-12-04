package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));

        for (int num : counts.keySet()) queue.offer(num);

        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
