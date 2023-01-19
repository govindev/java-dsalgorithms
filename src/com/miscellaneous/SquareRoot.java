package com.miscellaneous;

public class SquareRoot {
    public static void main(String[] args) {
        // mySqrt(2,14,73,95,600);2,14,68,23,780
        System.out.println(mySqrt(2147395600));
    }

    public static int mySqrt(int x) {
        // return mySqrtNaive(x);
        if (x == 0) return 0;
        int left = 1, right = x/2;
        while (left <= right) {
            int mid = (left+right)/2;
            if (mid == x/mid) return mid;
            else if (mid > x/mid) right = mid-1;
            else left = mid+1;
        }
        return Math.max(left-1, 1);
    }

    public int mySqrtNaive(int x) {
        int i = 1;
        while ((i*i) <= x) {
            i++;
        }
        return i-1;
    }
}
