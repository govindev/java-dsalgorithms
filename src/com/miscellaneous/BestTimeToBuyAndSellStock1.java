package com.miscellaneous;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int boughtAt = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - boughtAt);
            boughtAt = Math.min(boughtAt, prices[i]);
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        int left = 0, right = 1;
        while(right < prices.length) {
            if (prices[left] >= prices[right]) {
                left = right;
                right++;
            } else {
                int temp = prices[right]-prices[left];
                maxProfit = temp > maxProfit ? temp : maxProfit;
                right++;
            }
        }
        return maxProfit;
    }
}
