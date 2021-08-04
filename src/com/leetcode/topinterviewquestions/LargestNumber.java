package com.leetcode.topinterviewquestions;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums.length == 0)
			return "";
		if (nums.length == 1)
			return nums[0] + "";
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				long val1 = Long.parseLong(nums[i] + "" + nums[j]);
				long val2 = Long.parseLong(nums[j] + "" + nums[i]);
				if (val2 > val1) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (result.length() > 0 && result.charAt(0) == '0')
				break;
			result.append(nums[i] + "");
		}
		return result.toString();

	}
}
