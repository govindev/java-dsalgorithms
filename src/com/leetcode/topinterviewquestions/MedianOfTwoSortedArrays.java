package com.leetcode.topinterviewquestions;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		System.out.println(findMedianSortedArraysEfficeint(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				temp[k] = nums1[i];
				i++;
			} else {
				temp[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (i < nums1.length) {
			temp[k] = nums1[i];
			i++;
			k++;
		}
		while (j < nums2.length) {
			temp[k] = nums2[j];
			j++;
			k++;
		}
		if (temp.length % 2 == 0) {
			return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2.0;
		} else {
			return temp[temp.length / 2];
		}
	}

	public static double findMedianSortedArraysEfficeint(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0;
		int length = nums1.length + nums2.length;
		int mid1 = length / 2;
		int mid2 = length / 2 - 1;
		int mid1value = 0, mid2value = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				if (mid1 == k) {
					mid1value = nums1[i];
				} else if (mid2 == k) {
					mid2value = nums1[i];
				}
				i++;
			} else {
				if (mid1 == k) {
					mid1value = nums2[j];
				} else if (mid2 == k) {
					mid2value = nums2[j];
				}
				j++;
			}
			k++;
		}
		while (i < nums1.length) {
			if (mid1 == k) {
				mid1value = nums1[i];
			} else if (mid2 == k) {
				mid2value = nums1[i];
			}
			i++;
			k++;
		}
		while (j < nums2.length) {
			if (mid1 == k) {
				mid1value = nums2[j];
			} else if (mid2 == k) {
				mid2value = nums2[j];
			}
			j++;
			k++;
		}
		if (length % 2 == 0) {
			return (mid1value + mid2value) / 2.0;
		} else {
			return mid1value;
		}
	}
	
}
