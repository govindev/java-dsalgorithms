package com.gfg.dsalgo.searching;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Naive approach
        // Taking another array
        int[] nums = new int[nums1.length+nums2.length];
        int i = 0, i1=0, i2=0;
        for (; i < nums.length && i1 < nums1.length && i2 < nums2.length; i++) {
            if (nums1[i1] < nums2[i2]) {
                nums[i] = nums1[i1];
                i1++;
            } else {
                nums[i] = nums2[i2];
                i2++;
            }
        }
        for (; i < nums.length && i1 < nums1.length; i++, i1++) {
            nums[i] = nums1[i1];
        }
        for (; i < nums.length && i2 < nums2.length; i++, i2++) {
            nums[i] = nums2[i2];
        }

        int mid = nums.length/2;
        if (nums.length%2 == 0) {
            return (nums[mid-1] + nums[mid])/2.0;
        }
        return nums[mid];
    }
}
