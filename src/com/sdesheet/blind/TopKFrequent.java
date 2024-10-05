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
    public int[] topKFrequentOptimizedWithSingleMap(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 0;
        Map<Integer,List<Integer>> freqElementsMap = new HashMap<>();

        int currentFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            currentFreq++;
            if (i == nums.length-1 || nums[i] != nums[i+1]) {
                List<Integer> elements = freqElementsMap.getOrDefault(currentFreq, new ArrayList<>());
                elements.add(nums[i]);
                freqElementsMap.put(currentFreq, elements);
                maxFreq = Math.max(currentFreq, maxFreq);
                currentFreq = 0;
            }
        }

        int[] freqElements = new int[k];
        int i = 0;
        while (true) {
            List<Integer> elements = freqElementsMap.get(maxFreq--);
            if (elements != null && !elements.isEmpty()) {
                for (Integer element : elements) {
                    freqElements[i++] = element;
                    if (i == k) return freqElements;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(nums, 2);
    }
}
