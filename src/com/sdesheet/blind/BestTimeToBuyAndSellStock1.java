package com.sdesheet.blind;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int boughtPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            boughtPrice = Math.min(boughtPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - boughtPrice);
        }
        return maxProfit;
    }
}
