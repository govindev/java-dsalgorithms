package com.leetcode.topinterviewquestions;

import java.util.*;

public class Permutations {
	public static void main(String[] args) {

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(new ArrayList<>(), new boolean[nums.length], result, nums);
		return result;
	}

	public static void dfs(List<Integer> path, boolean[] used, List<List<Integer>> result, int[] nums) {
		if (path.size() == used.length) {
			// make a deep copy since otherwise we'd be append the same list over and over
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// skip used letters
			if (used[i])
				continue;
			// add letter to permuation, mark letter as used
			path.add(nums[i]);
			used[i] = true;
			dfs(path, used, result, nums);
			// remove letter from permutation, mark letter as unused
			path.remove(path.size() - 1);
			used[i] = false;
		}
	}
}
