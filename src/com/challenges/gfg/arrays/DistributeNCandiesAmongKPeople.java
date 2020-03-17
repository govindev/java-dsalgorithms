package com.challenges.gfg.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Given N candies and K people. In the first turn, the first person gets 1
 * candy, the second gets 2 candies, and so on till K people. In the next turn,
 * the first person gets K+1 candies, the second person gets k+2 candies and so
 * on. If the number of candies is less than the required number of candies at
 * every turn, then the person receives the remaining number of candies.
 * 
 * The task is to find the total number of candies every person has at the end.
 * 
 * Examples:
 * 
 * 
 * 
 * Input: N = 7, K = 4 Output: 1 2 3 1 At the first turn, the fourth people has
 * to be given 4 candies, but there is only 1 left, hence he takes one only.
 * 
 * Input: N = 10, K = 3 Output: 5 2 3 At the second turn first one receives 4
 * and then we have no more candies left.
 * 
 * @author Govind
 *
 */
public class DistributeNCandiesAmongKPeople {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // Number of Candies
		int k = Integer.parseInt(br.readLine()); // Number of Children
		int[] cCandies = new int[k];
		int c = 0; // Pointer
		while (n > 0) { // Till all the candies are distributed
			for (int i = 0; i < k; i++) {
				if (n > 0) {
					int candiesDistributed = (n > c + 1) ? c + 1 : n;
					cCandies[i] = (cCandies[i] > 0) ? cCandies[i] + candiesDistributed : candiesDistributed;
					n = n - candiesDistributed;
					c++;
				} else {
					break;
				}
			}
		}
		for (int candies : cCandies) {
			output.append(candies + " ");
		}
		System.out.println(output);
	}
}
