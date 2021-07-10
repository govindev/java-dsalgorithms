package com.leetcode.topinterviewquestions;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int reachable = 0, len = nums.length;
		for (int i = 0; i < len && i <= reachable; i++) {
			reachable = Math.max(reachable, i + nums[i]);
			if (reachable >= len - 1)
				return true; // terminate loop early to speed up
		}
		return false;
	}
}
