package com.sdesheet.neetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1 || nums.length <= 1) return nums;

        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();

        queue.offerLast(0);
        for (int i = 1; i < k; i++) {
            while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        res.add(nums[queue.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            while (queue.size() > 0 && (i-queue.peekFirst()) >= k) {
                queue.pollFirst();
            }
            while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            res.add(nums[queue.peekFirst()]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
