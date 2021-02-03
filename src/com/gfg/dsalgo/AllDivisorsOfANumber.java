package com.gfg.dsalgo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.NumberFormatException;

/**
 * 
 * @author Govind
 *
 */

public class AllDivisorsOfANumber {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		printAllDivisors(n);
	}

	private static void printAllDivisors(int n) {
		int i;
		for (i = 1; i * i < n; i++) {
			if (n % i == 0)
				System.out.print(i + " ");
		}
		for (; i >= 1; i--) {
			if (n % i == 0)
				System.out.print(n / i + " ");
		}
	}

	private static void printAllDivisors2(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	private static void printAllDivisors1(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != n / i)
					System.out.print(n / i + " ");
			}
		}
	}
}
