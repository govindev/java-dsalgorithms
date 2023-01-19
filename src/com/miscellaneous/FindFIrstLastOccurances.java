package com.miscellaneous;

import java.util.ArrayList;

public class FindFIrstLastOccurances {
    public int[] searchRange(int[] nums, int target) {
        int startingPosition = -1, endingPosition = -1;

        // Find the starting position of the target
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    startingPosition = mid;
                    break;
                } else {
                    right = mid-1;
                }
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        if (startingPosition == -1) return new int[] {-1, -1};

        // Find the ending position of the target
        left = 0; right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target) {
                    endingPosition = mid;
                    break;
                } else {
                    left = mid+1;
                }
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return new int[] { startingPosition, endingPosition };
    }
}
