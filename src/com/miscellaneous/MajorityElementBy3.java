package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementBy3 {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        if (nums.length == 1) return List.of(nums[0]);

        List<Integer> majorities = new ArrayList<>();

        int majority1 = -1, majority2 = -1, count1 = 0, count2 = 0;
        for (int num: nums) {
            if (majority1 == num) count1++;
            else if (majority2 == num) count2++;
            else if (count1 == 0) {
                majority1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                majority2 = num;
                count2 = 1;
            }
            else {
                count1--; count2--;
            }
        }
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (majority1 == num) count1++;
            else if (majority2 == num) count2++;
        }

        if (count1 > Math.ceil(nums.length/3)) majorities.add(majority1);
        if (count2 > Math.ceil(nums.length/3)) majorities.add(majority2);

        return majorities;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3};
        List<Integer> majorities = majorityElement(nums);
        majorities.forEach(majority -> System.out.println(majority + ","));
    }
}
