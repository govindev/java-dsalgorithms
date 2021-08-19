package com.leetcode.topinterviewquestions;

import java.util.*;

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (true) {
			int res = sum(n);
			if (res == 1)
				return true;
			if (set.contains(res)) {
				return false;
			}
			set.add(res);
			n = res;
		}
	}

	public int sum(int n) {
		int res = 0;
		while (n != 0) {
			int temp = n % 10;
			res = res + temp * temp;
			n = n / 10;
		}
		return res;
	}
}
