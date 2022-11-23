package com.miscellaneous;

public class LCM {
    public static void main(String[] args) {
        int a = 26, b = 53;
        LCM(a, b);
        LcmUsingGcd(a, b);
    }

    private static void LCM(int a, int b) {
        int lcm = Math.max(a, b);
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                System.out.println(lcm);
                return;
            }
            lcm++;
        }
    }

    private static void LcmUsingGcd(int a, int b) {
        System.out.println((a*b) / gcd(a,b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
