package com.miscellaneous;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 1. First sort the array to avoid duplicates
        Arrays.sort(nums);

        // 2. Declare the response
        List<List<Integer>> triplets = new ArrayList<>();

        if (nums.length < 3) return triplets;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left-1]) { left++; }
                }
                else if (sum > 0) right--;
                else left++;
            }
        }
        return triplets;
    }

    public List<List<Integer>> threeSumUsingHashing(int[] nums) {
        Set<List<Integer>> uniqTriplets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                int thirdElm = -(nums[i]+nums[j]);
                if (set.contains(thirdElm)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);triplet.add(thirdElm);

                    Collections.sort(triplet);
                    uniqTriplets.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqTriplets);
    }

    public List<List<Integer>> threeSumNew(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length - 1;
            while (left < right) {
                if (left > i+1 && left < nums.length - 1 && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                if (right > 0 && right < nums.length - 1 && nums[right] == nums[right+1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    // while (left < nums.length - 1 && nums[left] == nums[left-1]) left++;
                    right--;
                    // while (right > 0 && nums[right] == nums[right+1]) right--;
                }
                else if (sum > 0) {
                    right--;
                    // while (right > 0 && nums[right] == nums[right+1]) right--;
                }
                else {
                    left++;
                    // while (left < nums.length - 1 && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return triplets;
    }
}
