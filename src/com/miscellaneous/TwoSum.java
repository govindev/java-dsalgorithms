package com.miscellaneous;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;
        int[] answer = twoSum(nums, target);
        System.out.println("two sum is " + answer[0] + ", " + answer[1]);
    }
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);

        Arrays.sort(numsSorted);
        int left = 0, right = numsSorted.length - 1;
        while(left < right) {
            if (numsSorted[left] + numsSorted[right] == target) {
                left = numsSorted[left];
                right = numsSorted[right];
                break;
            }
            else if (numsSorted[left] + numsSorted[right] < target) {
                left++;
            }
            else right--;
        }

        int[] answer = new int[]{-1,-1};

        for (int i = 0; i < nums.length; i++) {
            if (answer[0] == -1 && nums[i] == left) {
                answer[0] = i;
            }
            else if (nums[i] == right) {
                answer[1] = i;
            }
        }
        return answer;

    }
}
