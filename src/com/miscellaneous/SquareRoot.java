package com.miscellaneous;

public class SquareRoot {
    public static void main(String[] args) {
        // mySqrt(2,14,73,95,600);2,14,68,23,780
        System.out.println(mySqrt(2147395600));
    }

    public static int mySqrt(int x) {
        if (x == 1) return 1;
        int low = 1, high = x/2;
        while (low <= high) {
            int mid = (low+high)/2;
            if (mid == x/mid) return mid;
            if (mid > x/mid) high = mid-1;
            else low = mid+1;
        }
        return low-1;
    }
}
