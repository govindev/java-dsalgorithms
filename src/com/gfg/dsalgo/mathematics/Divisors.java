package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Divisors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        printDivisors(n);
//        printDivisors1(n);
        printDivisorsOptimized(n);
    }

    private static void printDivisorsOptimized(int n) {
        int i = 1;
        for (; i*i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                System.out.println(n/i);
            }
        }
    }

    private static void printDivisors1(int n) {
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                System.out.println(n/i);
            }
        }
    }

    private static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}
