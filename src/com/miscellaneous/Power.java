package com.miscellaneous;

public class Power {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            n = (n == Integer.MIN_VALUE) ? Integer.MAX_VALUE-1 : -n;
            return 1/myPow(x, n);
        } else if (n%2 == 0) {
            double pow = myPow(x, n/2);
            return pow * pow;
        } else {
            return myPow(x, n-1) * x;
        }
    }
}
