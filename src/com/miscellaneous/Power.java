package com.miscellaneous;

public class Power {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = (n == Integer.MIN_VALUE) ? Integer.MAX_VALUE - 1 : (-1)*n;
            return 1 / myPow(x, n);
        }
        if (n == 0) return 1;

        if (n == 1) return x;

        if (n%2 == 0) {
            double half = myPow(x, n/2);
            return half * half;
        }
        return myPow(x, n-1) * x;
    }
}
