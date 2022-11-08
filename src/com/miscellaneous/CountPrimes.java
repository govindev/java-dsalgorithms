package com.miscellaneous;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        // Sieve of erathosis
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (!primes[i]) continue;
            int j = i*2;
            while(j < n) {
                primes[j] = false;
                j += i;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;

    }
    public int countPrimesLinear(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3 || n == 5) return true;
        if (n%2 == 0 || n%3 == 0 || n%5 == 0) return false;
        for (int i = 5; i*i <= n; i+=6) {
            if (n%i == 0) return false;
            if (n%(i+2) == 0) return false;
        }
        return true;
    }
}
