package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public int merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid+1, count = 0;
        for (i = left; i <= mid; i++) {
            while (j <= right && nums[i] > (long)nums[j]*2) j++;
            count += j - (mid+1);
        }

        List<Integer> temp = new ArrayList<>();
        i = left; j = mid+1;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp.add(nums[j]);
                j++;
            } else {
                temp.add(nums[i]);
                i++;
            }
        }

        while (i <= mid) temp.add(nums[i++]);
        while (j <= right) temp.add(nums[j++]);
        for (i = left; i <= right; i++) {
            nums[i] = temp.get(i - left);
        }
        return count;
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left+right)/2;
        int count = mergeSort(nums, left, mid);
        count += mergeSort(nums, mid+1, right);
        count += merge(nums, left, mid, right);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}
