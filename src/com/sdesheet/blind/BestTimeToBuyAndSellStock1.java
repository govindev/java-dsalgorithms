package com.sdesheet.blind;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, boughtPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            boughtPrice = Math.min(boughtPrice, price);
            maxProfit = Math.max(maxProfit, price - boughtPrice);
        }

        return maxProfit;
    }
}
