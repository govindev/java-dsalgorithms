package com.sdesheet.blind;

import java.util.*;

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
        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0)+1;
            counts.put(num, count);

            maxCount = Math.max(maxCount, count);
        }

        List<Integer>[] countWithNums = new List[maxCount+1];
        for (int num : counts.keySet()) {
            int countInd = counts.get(num);

            List<Integer> numsForCount = countWithNums[countInd];
            if (numsForCount == null) {
                numsForCount = new ArrayList<>();
            }
            numsForCount.add(num);
            countWithNums[countInd] = numsForCount;
        }

        int[] kFreqNums = new int[k];
        int freqNums = 0;
        for (int i = maxCount; i >= 0; i--) {
            if (freqNums == k) {
                break;
            }

            List<Integer> numsForCount = countWithNums[i];
            if (numsForCount == null) continue;
            for (Integer integer : numsForCount) {
                if (freqNums == k) {
                    break;
                }
                kFreqNums[freqNums++] = integer;
            }
        }
        return kFreqNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 2);
    }
}
