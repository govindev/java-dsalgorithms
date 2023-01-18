package com.sdesheet.neetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int len = nums1.length + nums2.length;

        int left = 0, right = nums1.length;
        while (left <= right) {
            int mid1 = (left + right)/2;
            int mid2 = (len+1)/2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int r1 = (mid1 == nums1.length) ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int r2 = (mid2 == nums2.length) ? Integer.MAX_VALUE : nums2[mid2];

            if ((l1 <= r2) && (l2 <= r1)) {
                if (len%2 == 0) return (double) (Math.max(l1,l2) + Math.min(r1,r2))/2;
                else return (double) Math.max(l1, l2);
            } else if (l2 > r1) left = mid1+1;
            else right = mid1-1;
        }
        return 0;
    }
}
