package com.gfg.dsalgo;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckForPrime {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("N : ");
		Integer n = Integer.parseInt(br.readLine().trim());
		if (checkForPrime(n)) {
			System.out.println("Given number is Prime");
		} else {
			System.out.println("Given number is Not Prime");
		}
	}

	private static boolean checkForPrime(int n) {
		// Time complexity is : square root of n
		if (n == 1 || n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	private static boolean checkForPrime2(int n) {
		// Time complexity is : square root of n
		if (n == 1)
			return true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static boolean checkForPrime1(int n) {
		// Naive solution. Time complexity : upper bound of n
		if (n == 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
