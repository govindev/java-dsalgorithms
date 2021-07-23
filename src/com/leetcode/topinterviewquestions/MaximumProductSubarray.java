package com.leetcode.topinterviewquestions;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		// This is a linear time complexity solution
		int max = 1, min = 1, res = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = 1;
				min = 1;
				res = Math.max(res, 0);
				continue;
			}
			int mul1 = nums[i] * max;
			int mul2 = nums[i] * min;
			max = Math.max(nums[i], Math.max(mul1, mul2));
			min = Math.min(nums[i], Math.min(mul1, mul2));
			res = Math.max(res, Math.max(max, nums[i]));
		}
		return res;
	}

	public int maxProductNSquare(int[] nums) {
		// This is an order n square solution
		int left = 0, right = 1;

		int maxProduct = nums[left];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (maxProduct < 0)
					maxProduct = 0;
				continue;
			}
			int currentProduct = nums[i];
			if (currentProduct > maxProduct)
				maxProduct = currentProduct;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == 0)
					break;
				currentProduct *= nums[j];
				if (currentProduct > maxProduct)
					maxProduct = currentProduct;
			}
		}
		return maxProduct;
	}
}
