package com.gfg.dsalgo.searching;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Fast and Slow pointer
        int slow = nums[0], fast = slow;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
