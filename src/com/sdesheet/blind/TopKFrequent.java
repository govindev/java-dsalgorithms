package com.sdesheet.blind;

import java.util.*;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // return topKFrequentUsingQueue(nums,k);
        return topKFrequentBestTimeComplexity(nums, k);
    }

    public int[] topKFrequentUsingQueue(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();

        Arrays.stream(nums).forEach(num -> numCounts.put(num, numCounts.getOrDefault(num, 0) + 1));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> numCounts.get(b) - numCounts.get(a));
        numCounts.keySet().forEach(num -> queue.offer(num));

        int[] topKFreq = new int[k];
        for (int i = 0; i < k; i++) {
            topKFreq[i] = queue.poll();
        }
        return topKFreq;
    }

    public int[] topKFrequentBestTimeComplexity(int[] nums, int k) {
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
