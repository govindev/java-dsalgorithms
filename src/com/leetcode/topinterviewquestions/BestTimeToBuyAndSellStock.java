package com.leetcode.topinterviewquestions;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int maxProfit = 0;
		int left = 0, right = 1;
		while (right < prices.length) {
			if (prices[left] >= prices[right]) {
				left = right;
				right++;
			} else {
				int temp = prices[right] - prices[left];
				maxProfit = temp > maxProfit ? temp : maxProfit;
				right++;
			}
		}
		return maxProfit;
	}
}