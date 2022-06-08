package com.gfg.dsalgo.others;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;

public class PrimeFactors {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine().trim());

		printPrimeFactors2(n);
	}

	private static void printPrimeFactors2(int n) {
		// best solution.
		if (n <= 1)
			return;
		while (n % 2 == 0) {
			System.out.print("2, ");
			n = n / 2;
		}
		while (n % 3 == 0) {
			System.out.print("3, ");
			n = n / 3;
		}
		for (int i = 5; i * i <= n; i = i + 6) {
			while (n % i == 0) {
				System.out.print(i + ", ");
				n = n / i;
			}
			while (n % (i + 2) == 0) {
				System.out.print(i + 2);
				System.out.print(", ");
			}
		}
		if (n > 3) {
			System.out.print(n);
		}
	}

	private static void printPrimeFactors1(int n) {
		// better solution. order of logn
		if (n <= 1)
			return;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				System.out.print(i + ", ");
				n = n / i;
			}
		}
		if (n > 1)
			System.out.println(n);
	}

	private static void printPrimeFactors(int n) {
		// Naive solution
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				int x = i;
				while (n % x == 0) {
					System.out.print(i + ", ");
					x = x * i;
				}
			}
		}
	}

	private static boolean isPrime(int n) {
		if (n == 2 || n == 3) {
			return true;
		}
		if (n == 1 || n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i <= n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

}
