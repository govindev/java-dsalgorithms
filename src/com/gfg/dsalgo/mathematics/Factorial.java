package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Factorial {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }

    private static int factorial(int number) {
        int fact = 1;
        for (int i = 2; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

}
