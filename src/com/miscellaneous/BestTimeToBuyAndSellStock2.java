package com.miscellaneous;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int boughtPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < boughtPrice) {
                boughtPrice = prices[i];
            } else {
                maxProfit += prices[i] - boughtPrice;
                boughtPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
