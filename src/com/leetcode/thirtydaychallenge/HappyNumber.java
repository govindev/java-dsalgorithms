package com.leetcode.thirtydaychallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HappyNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Read the number
		int number = Integer.parseInt(br.readLine());
		// Check whether it is a happy number or not and print the status accordingly
		System.out.println("Happy Number status : " + isHappy(number));

	}

	public static boolean isHappy(int n) {
		n = 2;
		while (true) {
			int prevSum = 0;
			while (n != 0) {
				int lastDig = n % 10;
				n = n / 10;
				prevSum += lastDig * lastDig;
			}
			if (prevSum == 1)
				return true;
			n = prevSum;
		}
	}
}
