package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class PrintPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        printPrimesBeforeNaive(n);
//        printPrimesBeforeSieve(n);
        printPrimesBeforeSieveOptimized(n);
    }

    private static void printPrimesBeforeSieveOptimized(int n) {
        // Sieve of Eratosthenes
        // time complexity is O(nloglogn) < O(n*sqrt(n))
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                for (int j = i*i; j <= n; j=j+i) {
                    primes[j] = false;
                }
                System.out.print(i + ",");
            }
        }
    }

    private static void printPrimesBeforeSieve(int n) {
        // Sieve of Eratosthenes
        // time complexity is O(nloglogn) < O(n*sqrt(n))
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for(int i = 2; i*i <= n; i++) {
            if (isPrime(i)) {
                for (int j = i*2; j <= n; j=j+i) {
                    primes[j] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if (primes[i])
             System.out.print(i + ",");
        }
    }

    private static void printPrimesBeforeNaive(int n) {
        // time complexity is O(n*sqrt(n))
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + ",");
            }
        }
    }

    private static boolean isPrime(int n) {
        // time complexity is O(sqrt(n))
        if (n == 2 || n == 3) return true;
        if (n <= 1 || n%2 == 0 || n%3 == 0) return false;
        for (int i = 5; i*i <= n; i=i+6) {
            if (n%i == 0 || n%(i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
