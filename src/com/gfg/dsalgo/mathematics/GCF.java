package com.gfg.dsalgo.mathematics;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GCF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println("GCF of " + a + " and " + b + " is " + gcfEuclidianOptimized(a, b));
    }

    private static int gcfNaive(int a, int b) {
        int div = Math.min(a, b);
        for (int i = div; i >= 1; i--) {
            if (a%i == 0 && b%i == 0) {
                return i;
            }
        }
        return 1;
    }

    // Euclidian
    private static int gcfEuclidian(int a, int b) {
        while(a != b) {
            if (a > b) {
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }

    // Euclidian Optimized
    private static int gcfEuclidianOptimized(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcfEuclidianOptimized(b, a%b);
    }
}
