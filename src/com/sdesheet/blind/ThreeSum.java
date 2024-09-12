package com.sdesheet.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

		List<List<Integer>> triplets = new ArrayList<>();

		if (nums == null || nums.length < 3) return triplets;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i-1]) {
				continue;
			}

			int left = i+1, right = nums.length - 1;

			while (left < right) {

				int sum = nums[left]+nums[right]+nums[i];
				if (sum == 0) {
					triplets.add(List.of(nums[i], nums[left], nums[right]));

					do {
						left++;
					} while (nums[left] == nums[left-1] && left < right);

				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}

		return triplets;
	}

}
