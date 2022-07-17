package com.sdesheet.striver;

/***
 * https://leetcode.com/problems/merge-sorted-array/submissions/
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, f = m+n-1;
        for (; f >= 0; f--) {
            if (i < 0 || j < 0) break;
            if (nums2[j] > nums1[i]) {
                nums1[f] = nums2[j];
                j--;
            } else {
                nums1[f] = nums1[i];
                i--;
            }
        }
        while (j >= 0) {
            nums1[f] = nums2[j];
            j--; f--;
        }

    }
}
