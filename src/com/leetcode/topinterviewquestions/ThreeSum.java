package com.leetcode.topinterviewquestions;

import java.util.*;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(nums);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.size(); i++) {
			sb.append("[");
			for (int j = 0; j < res.get(i).size(); j++) {
				sb.append(res.get(i).get(j) + ",");
			}
			sb.append("]");
		}
		System.out.println(sb.toString());
	}

	public static List<List<Integer>> threeSumNaive(int[] nums) {
		// Order of n3 solution
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i <= nums.length - 3; i++) {
			for (int j = i + 1; j <= nums.length - 2; j++) {
				for (int k = j + 1; k <= nums.length - 1; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> match = new ArrayList<>();
						match.add(nums[i]);
						match.add(nums[j]);
						match.add(nums[k]);
						result.add(match);
					}
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();

		// Sort the Array
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int sum = 0 - nums[i];
				int low = i + 1;
				int high = nums.length - 1;

				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low + 1] == nums[low]) {
							low++;
						}
						while (low < high && nums[high - 1] == nums[high]) {
							high--;
						}
						low++;
						high--;
					} else if (nums[low] + nums[high] > sum) {
						high--;
					} else {
						low++;
					}
				}
			}
		}

		return res;
	}

}
