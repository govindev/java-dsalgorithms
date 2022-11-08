package com.miscellaneous;

public class GeekNumber {
    static int geekNumber(int N){
        // code here
        for (int i = 2; i*i <= N; i++) {
            if (isPrime(i)) {
                if (N%i == 0) N = N/i;
                if (N%i == 0) return 0;
            }
        }
        return 1;
    }

    private static boolean isPrime(int n) {
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
