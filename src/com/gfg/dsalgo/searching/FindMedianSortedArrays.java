package com.gfg.dsalgo.searching;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        findMedianSortedArrays(arr1, arr2);
    }

    public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
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


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);


        int left = 0, right = n1;
        while (left < right) {
            int p1 = (left+right)/2;
            int p2 = ((n1+n2+1)/2) - p1;

            int v1r = (p1 == n1) ? Integer.MAX_VALUE : nums1[p1];
            int v1l = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1-1];

            int v2r = (p2 == n2) ? Integer.MAX_VALUE : nums2[p2];
            int v2l = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2-1];

            if (v1l <= v2r && v2l <= v1r) {
                if ((n1+n2) % 2 == 0) {
                    return (double) (Math.max(v1l, v2l) + Math.min(v1r, v2r)) / 2;
                }
                return (double) Math.max(v1l, v2l);
            } else if (v1l > v2r) {
                right  = p1-1;
            } else {
                left = p1+1;
            }
        }
        return -1;
    }

}
