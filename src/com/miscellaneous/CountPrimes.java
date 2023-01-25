package com.miscellaneous;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                count++;
                int x = i*2;
                while (x < n) {
                    primes[x] = 0;
                    x += i;
                }
            }
        }

        return count;
    }

    public int countPrimesLinear(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3 || num == 5) return true;
        if (num%2 == 0 || num%3 == 0 || num%5 == 0) return false;
        for (int i = 5; i*i <= num; i+=6) {
            if (num%i == 0 || num%(i+2) == 0) return false;
        }
        return true;
    }
}
