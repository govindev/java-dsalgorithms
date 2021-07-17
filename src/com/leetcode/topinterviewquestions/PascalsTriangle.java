package com.leetcode.topinterviewquestions;

import java.util.*;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		generate(numRows, result);
		return result;
	}

	public List<Integer> generate(int n, List<List<Integer>> result) {
		if (n == 1) {
			result.add(Arrays.asList(1));
			return Arrays.asList(1);
		} else if (n == 2) {
			result.add(Arrays.asList(1));
			result.add(Arrays.asList(1, 1));
			return Arrays.asList(1, 1);
		} else {
			List<Integer> preList = generate(n - 1, result);
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			for (int i = 0; i <= preList.size() - 2; i++) {
				list.add(preList.get(i) + preList.get(i + 1));
			}
			list.add(1);
			result.add(list);
			return list;
		}

	}
}