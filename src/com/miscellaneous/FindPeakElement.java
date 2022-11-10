package com.miscellaneous;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(" peak is : " + findPeakElement(new int[] {1,2,3,1}));
    }
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            } else if (mid != 0 && nums[mid] < nums[mid-1]) {
                right = mid-1;
            } else left = mid+1;
        }
        return -1;
    }
}
