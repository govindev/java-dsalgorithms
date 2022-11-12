package com.miscellaneous;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] > nums[slow-1]) {
                slow++;
                if (fast < slow) fast = slow;
            }
            else if (nums[fast] > nums[slow-1]) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}
