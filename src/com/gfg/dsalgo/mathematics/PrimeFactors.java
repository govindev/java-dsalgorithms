package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrimeFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        printPrimeFactorsNaive(n);
//        printPrimeFactors(n);
        printPrimeFactorsOptimized(n);
    }

    private static void printPrimeFactorsOptimized(int n) {
        if(n <= 1) return;
        while(n%2 == 0) {
            n = n / 2;
            System.out.println(2 + ",");
        }
        while(n%3 == 0) {
            n = n / 3;
            System.out.println(3 + ",");
        }
        for (int i = 5; i*i <= n; i=i+6) {
            while (n % i == 0) {
                System.out.println(i + ", ");
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                System.out.println(i + 2 + ", ");
                n = n / (i+2);
            }
        }
        if (n > 3)
            System.out.println(n);
    }

    private static void printPrimeFactors(int n) {
        if(n <= 1) return;
        for (int i = 2; i*i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i + ", ");
                n = n/i;
            }
        }
        if (n > 1)
            System.out.println(n);
    }


    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n <= 1 || n%2 == 0 || n%3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i=i+6) {
            if (n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }

    private static void printPrimeFactorsNaive(int n) {
        if (n <= 1) return;
        for (int i = 2; i < n; i++) {
            if(isPrime(i)) {
                int x = i;
                while(n % x == 0) {
                    System.out.println(i + ", ");
                    x = x*i;
                }
            }
        }
    }
}
