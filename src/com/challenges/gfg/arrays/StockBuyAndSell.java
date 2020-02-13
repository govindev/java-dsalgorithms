package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//
//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
//The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
//
//Input: 
//First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days. 
//
//Output:
//For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".
//
//Constraints:
//1 <= T <= 100
//2 <= N <= 103
//0 <= Ai <= 104
//
//Example
//Input:
//2
//7
//100 180 260 310 40 535 695
//10
//23 13 25 29 33 19 34 45 65 67
//
//Output:
//(0 3) (4 6)
//(1 4) (5 9)
//
//Explanation:
//Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.
//
//Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
//For each input, output should be in a single line.

public class StockBuyAndSell {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int length = Integer.parseInt(br.readLine());
			String[] array = br.readLine().split(" ");
			int boughtInd = 0, prevInd = 0;
			int boughtVal = Integer.parseInt(array[0]), prevVal = boughtVal;
			for (int j = 1; j < length; j++) {
				if (prevVal > Integer.parseInt(array[j])) {
					// Should sell here as the current val is than prev day val
					// Check whether there any days happened after the bought day
					if (boughtInd == prevInd) {
						// No days happened
						// Simply ignore and buy the stocks today and keep moving
						boughtInd = prevInd = j;
						boughtVal = prevVal = Integer.parseInt(array[j]);
					} else {
						sb.append("(" + boughtInd + " " + prevInd + ") ");
						// After sold buy the stocks now and keep moving
						boughtInd = prevInd = j;
						boughtVal = prevVal = Integer.parseInt(array[j]);
					}
				} else {
					prevInd = j;
					prevVal = Integer.parseInt(array[j]);
				}
			}
			if (prevInd > boughtInd) {
				sb.append("(" + boughtInd + " " + prevInd + ") ");
			}
			if (boughtInd == prevInd && prevInd == 1) {
				sb.append("No Profit");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
