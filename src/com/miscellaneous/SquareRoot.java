package com.miscellaneous;

public class SquareRoot {
    public static void main(String[] args) {
        // mySqrt(2,14,73,95,600);2,14,68,23,780
        System.out.println(mySqrt(2147395600));
    }

    public static int mySqrtNaive(int x) {
        long res = 1;
        while (res*res <= x) {
            res++;
        }
        return (int)res-1;
    }

    public static int mySqrt(int x) {
        long res = 1;
        while (res*res <= x) {
            res *= 2;
        }
        // between res/2 and res
        long left = res/2, right = res;
        if (left*left == x) return (int) left;
        if (right*right == x) return (int) right;
        while (left < right) {
            long mid = (left+right)/2;
            if (mid*mid == x) return (int)mid;
            else if (mid*mid > x) right = mid-1;
            else left = mid+1;
        }
        return (left*left <= x) ? (int) left : (int) left-1;
    }
}
