package com.gfg.dsalgo;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;

public class DivisorsOfANumber {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine().trim());
		printDivisorsOfNumber2(n);
	}

	private static void printDivisorsOfNumber(int n) {
		// Naive solution
		System.out.print(1 + ", ");
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + ", ");
			}
		}
	}

	private static void printDivisorsOfNumber1(int n) {
		System.out.print("1, ");
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {

				System.out.print(i + ", ");
				if (i != (n / i)) {
					System.out.print(n / i + ", ");
				}
			}
		}
	}

	private static void printDivisorsOfNumber2(int n) {
		int i;
		for (i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + ", ");
			}
		}
		for (; i > 1; i--) {
			if (n % i == 0 && i != (n / i)) {
				System.out.print(n / i + ", ");
			}
		}
	}
}
