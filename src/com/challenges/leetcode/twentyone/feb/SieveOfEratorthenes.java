package com.challenges.leetcode.twentyone.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;
import java.io.IOException;

public class SieveOfEratorthenes {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine().trim());
		// printPrimeNumbers(n);
		sieveAlgo1(n);
	}

	private static void printPrimeNumbers(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.print(i + ", ");
			}
		}
	}

	private static void sieveAlgo1(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				System.out.print(i + ", ");
				for (int j = i * i; j <= n; j = j + i) {
					isPrime[j] = false;
				}
			}
		}
	}

	private static void sieveAlgo(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j <= n; j = j + i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i])
				System.out.print(i + ", ");
		}
	}

	private static void sieveAlgoWrong(int n) {
		Boolean[] primes = new Boolean[n + 1];
		int i = 4;
		while (i <= n) {
			primes[i] = false;
			i = i + 2;
		}
		i = 6;
		while (i <= n) {
			primes[i] = false;
			i = i + 3;
		}
		i = 10;
		while (i <= n) {
			primes[i] = false;
			i = i + 5;
		}
		for (i = 2; i < primes.length; i++) {
			if (primes[i] == null)
				System.out.print(i + ", ");
		}
	}

	private static boolean isPrime(int i) {
		if (i <= 1) {
			return false;
		}
		if (i == 2 || i == 3) {
			return true;
		}
		if (i % 2 == 0 || i % 3 == 0) {
			return false;
		}
		for (int j = 5; j * j <= i; j = j + 6) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
