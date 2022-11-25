package com.miscellaneous;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = nums1.length - 1;
        while (k >= 0) {
            if ((i >= 0 && j >= 0 && nums1[i] > nums2[j])
                    || (i >= 0 && j < 0)) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}
