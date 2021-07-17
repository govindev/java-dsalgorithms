package com.leetcode.topinterviewquestions;

public class BestTimeToBuyAndSellStock2 {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int maxProfit = 0, left = 0, right = 1;
		while (right < prices.length) {
			if (prices[left] >= prices[right]) {
				left = right;
				right++;
			} else if (right + 1 < prices.length && prices[right + 1] >= prices[right]) {
				right++;
			} else {
				maxProfit += prices[right] - prices[left];
				left = right;
				right++;
			}
		}
		return maxProfit;
	}
}
