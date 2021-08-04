package com.leetcode.topinterviewquestions;

public class LargestNumber {

	private static int[] merge(int[] array1, int[] array2) {
		int[] array3 = new int[array1.length + array2.length];
		int i = 0, j = 0, k = 0;
		for (; k < array3.length; k++) {
			if (i >= array1.length || j >= array2.length)
				break;
			long val1 = Long.parseLong(array1[i] + "" + array2[j]);
			long val2 = Long.parseLong(array2[j] + "" + array1[i]);
			if (val2 > val1) {
				array3[k] = array2[j];
				j++;
			} else {
				array3[k] = array1[i];
				i++;
			}
		}
		while (i < array1.length) {
			array3[k++] = array1[i++];
		}
		while (j < array2.length) {
			array3[k++] = array2[j++];
		}
		return array3;
	}

	private static int[] mergeSort(int start, int end, int[] array) {
		if (start < end && start < array.length && end < array.length && (end - start >= 1)) {
			if (end - start == 1) {
				// If only two elements are there
				int[] array1 = { array[start] };
				int[] array2 = { array[end] };
				return merge(array1, array2);
			} else {
				int mid = (int) (start + end) / 2;
				int[] array1 = mergeSort(start, mid - 1, array);
				int[] array2 = mergeSort(mid, end, array);
				return merge(array1, array2);
			}
		} else {
			// If only single element is there, we don't need to sort it; we can just simply
			// return
			int[] array3 = { array[start] };
			return array3;
		}
	}

	public static String largestNumber(int[] nums) {
		// Merge Sort
		nums = mergeSort(0, nums.length-1, nums);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (result.length() > 0 && result.charAt(0) == '0')
				break;
			result.append(nums[i] + "");
		}
		return result.toString();
	}

	public String largestNumberNaive(int[] nums) {
		// Order of n square
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

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 30, 34, 5, 9 };
		largestNumber(nums);
	}
}
