package com.challenges.leetcode.twentyone.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class ComputingPower {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer x = Integer.parseInt(br.readLine().trim());
		Integer n = Integer.parseInt(br.readLine().trim());
		System.out.println(iterPow(x, n));
	}

	private static int iterPow(int x, int n) {
		int result = 1;
		// iterative solution
		while (n > 0) {
			if (n % 2 != 0) {
				// Odd number
				result = result * x;
			}
			x = x * x;
			n = n / 2;
		}
		return result;
	}

	private static int recPow(int x, int y) {
		// recursive solution
		// time and aux space complexity is theta of n
		if (y == 0)
			return 1;
		int result = 1;
		int temp = recPow(x, y / 2);
		result = temp * temp;
		if (y % 2 == 0)
			return result;
		else
			return result * x;
	}

	private static int pow(int x, int n) {
		// Naive soultion
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		int result = x;
		for (int i = 2; i <= n; i++) {
			result = result * x;
		}
		return result;
	}

}
