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

    public int removeDuplicatesNew(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int vPtr = 0;
        int cPtr = 1;
        while (cPtr < nums.length) {
            if (nums[vPtr] == nums[cPtr]) {
                cPtr++;
                continue;
            }
            // Put cPtr element at vPtr+1 index
            nums[++vPtr] = nums[cPtr++];
        }
        return vPtr+1;
    }
}
