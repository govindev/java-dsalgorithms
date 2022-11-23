package com.miscellaneous;

public class GCD {
    public static void main(String[] args) {
        gcd(5, 7);
        gcdEuclidian(253, 276);
        gcdEuclidian(253, 276);
    }

    private static void gcd(int a, int b) {
        int gcd = Math.min(a, b);
        while(true) {
            if (a%gcd == 0 && b%gcd == 0) {
                System.out.println(gcd);
                return;
            }
            gcd--;
        }
    }

    private static void gcdEuclidian(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a-b;
            else
                b = b-a;
        }
        System.out.println(a);
    }

    private static void gcdEuclidianOpt(int a, int b) {
        if (b == 0) {
            System.out.println(a);
            return;
        }
        gcdEuclidianOpt(b, a%b);
    }
}
