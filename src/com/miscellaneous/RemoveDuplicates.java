package com.miscellaneous;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] < nums[fast]) {
                if (slow+1 != fast) {
                    nums[slow+1] = nums[fast];
                }
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow + 1;
    }
}
