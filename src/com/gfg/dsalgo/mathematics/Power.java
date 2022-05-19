package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Power {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        System.out.println(x + " to the power of " + n + " is " + powNaive(x,n));
        System.out.println(x + " to the power of " + n + " is " + pow(x,n));
        System.out.println(x + " to the power of " + n + " is " + powOptimized(x,n));
    }

    private static int powOptimized (int x, int n) {
        // Try to use long for the result for longer numbers
        // If the result overflow take the modular m and
        // change the lines to res = res * x % m and x = x*x % m

        int res = 1;
        while (n > 0) {
            if (n%2 != 0) { // Can be written as n&1
                res = res * x;
            }
            x = x * x;
            n = n / 2; // Can be written as n>>1
        }
        return res;
    }

    private static int pow(int x, int n) {
        // Efficient solution
        // pow(x, n) = pow(x, n/2) * pow(x, n/2); => if n is even
        // pow(x, n) = pow(x, n-1) * x; => if n is odd
        if (n == 0) return 1;
        int pow = pow(x, n/2);
        if (n%2 == 0) {
            return pow * pow;
        } else {
            return pow * pow * x;
        }
    }


    private static int powNaive(int x, int n) {
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= x;
        }
        return pow;
    }
}
