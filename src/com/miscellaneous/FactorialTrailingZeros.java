package com.miscellaneous;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int res = 0, x = 5;
        while (n/x >= 1) {
            res += n/x;
            x *= 5;
        }

        return res;
    }
}
