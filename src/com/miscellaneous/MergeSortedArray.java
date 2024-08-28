package com.miscellaneous;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m+n-1;
        int p1 = m-1, p2 = n-1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[curr--] = nums1[p1--];
            }
            else {
                nums1[curr--] = nums2[p2--];
            }
        }
        while (p1 >= 0) {
            nums1[curr--] = nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[curr--] = nums2[p2--];
        }
    }

    public void mergeExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i = 0, j = 0, l = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[l++] = nums1[i++];
            }
            else {
                temp[l++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[l++] = nums1[i++];
        }
        while (j < n) {
            temp[l++] = nums2[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums1[k] = temp[k];
        }
    }
}
