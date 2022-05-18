package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZerosInFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
//        System.out.println("Zeros of Factorial of " + number + " is " + countZerosNaive(factorial(number)));
        System.out.println("Zeros of Factorial of " + number + " is " + countZeros(number));
    }

    private static int factorial(int number) {
        int fact = 1;
        for(int i = 2; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int countZerosNaive(int number) {
        int count = 0;
        while(number != 0) {
            if(number % 10 != 0) break;
            count++;
            number = number / 10;
        }
        return count;
    }

    private static int countZeros(int number) {
        int count = 0;
        for (int i = 5; i <= number; i=i*5) {
            count += number / i;
        }
        return count;
    }
}
