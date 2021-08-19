package com.leetcode.topinterviewquestions;

public class HammingWeight {
	public int hammingWeight(int n) {
		int weight = 0;
		int i = 0;
		while (n > 0 || i < 32) {
			if ((n & 1) == 1)
				weight++;
			n = n >> 1;
			i++;
		}
		return weight;
	}
}
