package com.gfg.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockBuyAndSell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int size = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements : ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Max profit : " + maxProfit(array));
    }

    private static int maxProfit(int[] array) {
        int bInd = 0;
        int maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                maxProfit = maxProfit + array[i-1] - array[bInd];
                bInd = i;
            }
        }
        maxProfit = maxProfit + array[array.length-1] - array[bInd];
        return maxProfit;
    }

    private static int maxProfitEffective(int[] array) {
        int maxProfit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                maxProfit += array[i] - array[i-1];
            }
        }
        return maxProfit;
    }
}
