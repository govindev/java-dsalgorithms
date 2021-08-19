package com.leetcode.topinterviewquestions;

public class CountPrimes {

	public int countPrimes(int n) {
		// Better time complexity
		// order of log n

		boolean[] notPrimes = new boolean[n];
		// Arrays.fill(primes, true);
		for (int i = 2; i * i < n; i++) {
			if (!notPrimes[i]) {
				for (int j = i; i * j < n; j++) {
					notPrimes[i * j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrimes[i])
				count++;
		}
		return count;
	}

	public int countPrimesBetterSpace(int n) {
		// Better space complexity
		// Order of n - time complexity
		if (n <= 2)
			return 0;
		if (n <= 3)
			return 1;
		int count = 2;
		for (int i = 5; i < n; i = i + 6) {
			if (isPrime(i))
				count++;
			if (i + 2 < n && isPrime(i + 2))
				count++;
		}
		return count;
	}

	public boolean isPrime(int n) {
		for (int i = 5; i * i <= n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
}
