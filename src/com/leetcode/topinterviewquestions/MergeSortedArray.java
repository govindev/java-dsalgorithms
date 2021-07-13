package com.leetcode.topinterviewquestions;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 4, 5, 6, 0 };
		int m = 5;
		int[] nums2 = new int[] { 3 };
		int n = 1;
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Idea is to do the Merge sort from end to start
		m--;
		n--;
		for (int i = nums1.length - 1; i >= 0; i--) {
			if (n < 0)
				return;
			if (m >= 0 && nums1[m] > nums2[n]) {
				nums1[i] = nums1[m];
				m--;
			} else {
				nums1[i] = nums2[n];
				n--;
			}
		}
	}

}
