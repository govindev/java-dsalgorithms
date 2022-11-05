package com.miscellaneous;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int boughtPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > boughtPrice) {
                profit += prices[i] - boughtPrice;
            }
            boughtPrice = prices[i];
        }
        return profit;
    }
}
