package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Best Time to Buy and Sell Stock II 
 * Say you have an array prices for which the
 * ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1) and sell
 * on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price = 3) and
 * sell on day 5 (price = 6), profit = 6-3 = 3. Example 2:
 * 
 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell
 * on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1,
 * buy on day 2 and sell them later, as you are engaging multiple transactions
 * at the same time. You must sell before buying again. Example 3:
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is
 * done, i.e. max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 3 * 10 ^ 4 0 <= prices[i] <= 10 ^ 4
 * 
 * @author Govind
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrayOfPrices = br.readLine().split(",");
		int[] prices = new int[arrayOfPrices.length];
		int ind = 0;
		for (String price : arrayOfPrices) {
			prices[ind++] = Integer.parseInt(price);
		}
		System.out.println("Max Profit is : " + maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int buyIndex = 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				// Sell the previous stock
				profit += prices[i - 1] - prices[buyIndex];
				// Buy the Stock now
				buyIndex = i;
			}
		}
		if (buyIndex != prices.length - 1) {
			// At no point in time the stock went down after this buyIndex
			// So sell it at the end to see max profit
			profit += prices[prices.length - 1] - prices[buyIndex];
		}
		return profit;
	}
}
