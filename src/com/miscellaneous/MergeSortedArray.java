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

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // Idea is to start from the end and move towards left
        int p1 = m - 1, p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (p1 < 0 && p2 < 0) return;
            else if (p1 < 0) {
                nums1[i] = nums2[p2];
                p2--;
            } else if (p2 < 0) {
                nums1[i] = nums1[p1];
                p1--;
            } else if (nums2[p2] > nums1[p1]) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
        }
    }
}
