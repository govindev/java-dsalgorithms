package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
//        System.out.println("Ruf of " + a + " and " + b + " is : " + lcm(a, b));
        System.out.println("Ruf of " + a + " and " + b + " is : " + lcmOptimized(a, b));
    }

    private static int lcm(int a, int b) {
        int l = Math.max(a, b);
        while(true) {
            if (l%a == 0 && l%b == 0) {
                return l;
            }
            l++;
        }
    }

    // Euclidian optimized
    // a*b = gcd(a,b) * lcm(a,b)
    private static int lcmOptimized(int a, int b) {
        return (a*b) / gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
