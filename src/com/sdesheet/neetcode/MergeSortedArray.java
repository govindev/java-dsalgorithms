package com.sdesheet.neetcode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m-1, ni = n-1, k = m+n-1;
        while(k >= 0) {
            if (ni < 0) break;
            if (mi >= 0 && nums1[mi] > nums2[ni]) {
                nums1[k] = nums1[mi];
                mi--;
                k--;
            } else {
                nums1[k] = nums2[ni];
                ni--;
                k--;
            }
        }
    }
}
