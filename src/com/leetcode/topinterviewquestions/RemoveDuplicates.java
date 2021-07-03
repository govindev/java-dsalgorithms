package com.leetcode.topinterviewquestions;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {
		if (nums.length < 1)
			return 0;
		int nInd = 0, nIndElmt = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nIndElmt) {
				nIndElmt = nums[i];
				nInd++;
				nums[nInd] = nIndElmt;
			}
		}
		return nInd + 1;
	}

}
