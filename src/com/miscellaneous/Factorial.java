package com.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Factorial of " + n + " is " + findFactorial(n));
    }

    private static long findFactorial(int n) {
        long fact = n;
        while (n > 1) fact *= --n;
        return fact;
    }
}
