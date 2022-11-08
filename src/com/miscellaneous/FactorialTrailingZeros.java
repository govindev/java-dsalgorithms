package com.miscellaneous;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int x = 5, res=0;
        while (n/x >= 1) {
            res += n/x;
            x *= 5;
        }
        return res;
    }
}
