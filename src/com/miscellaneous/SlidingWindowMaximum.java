package com.miscellaneous;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1,2,0,5};
        int k = 3;
        int[] windowsMax = maxSlidingWindow(nums, k);
        for (int max : windowsMax) {
            System.out.println(max + ", ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];

        // Add k elements to the queue
        int i = 0;
        for (; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        int ind = 0;
        res[ind++] = nums[queue.getFirst()];
        for (; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getFirst() <= (i-k)) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            res[ind++] = nums[queue.getFirst()];
        }

        return res;
    }
}
