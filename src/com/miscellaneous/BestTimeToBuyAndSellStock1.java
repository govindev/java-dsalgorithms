package com.miscellaneous;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit1(int[] prices) {
        int boughtAt = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < boughtAt) {
                boughtAt = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - boughtAt);
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
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
