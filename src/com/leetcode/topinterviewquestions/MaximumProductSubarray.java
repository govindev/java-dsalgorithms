package com.leetcode.topinterviewquestions;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
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
