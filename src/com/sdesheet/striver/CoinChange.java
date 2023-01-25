package com.sdesheet.striver;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public static void main(String[] args) {
//        int[] coins = new int[] {186,419,83,408};
//        int amount = 6249;
        int[] coins = new int[] {411,412,413,414,415,416,417,418,419,420,421,422};
        int amount = 9864;
//        System.out.println(coinChange(coins, amount));
        System.out.println(minCoins(coins, amount));
    }

    public static int minCoins(int coins[], int amount) {
        // 1. Sort the coins based on the denominations
        coins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        // DP solution
        // Bottom up approach
        if (amount < 0 || coins.length == 0 || coins == null) return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public static int coinChange(int[] coins, int amount) {
        // 1. Sort the coins based on the denominations
//        Arrays.sort(coins);
        coins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        return coinChange(coins, amount, 0);
    }

    public static int coinChange(int[] coins, int amount, int ind) {
        // DFS - Depth First Search
        // Time limit exceeded
        if (amount == 0) return 0;
        if (ind >= coins.length) return -1;

        if (coins[ind] == amount) return 1;
        if (coins[ind] > amount) return coinChange(coins, amount, ind+1);

        int change = coinChange(coins, amount-coins[ind], ind);
        if (change == -1) return coinChange(coins, amount, ind+1);

        int nextChange = coinChange(coins, amount, ind+1);
        if (nextChange == -1) return 1+change;

        return Math.min(1+change, nextChange);
    }

    public int minCoinsGreedy(int coins[], int M, int V)
    {
        // It is partially correct
        // Doesn't work for [9,6,5,1] 11 {O/P : 3, Right O/P : 2}
        // Works for [9,6,1] 11 {O/P : 3, Right O/P : 3}
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= V) {
                V -= coins[i];
                count++;
                i--;
            }
        }
        return count;
    }
}
