package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        if(isPrime(number)) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Number is not prime");
        }
    }

    private static boolean isPrimeNaive(int number) {
        if (number == 1) return false;
        for( int i = 2; i < number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(int number) {
        if (number == 2 || number == 3) return true;
        if (number == 1 || number%2 == 0 || number%3 == 0) return false;
        for (int i = 5; i*i <= number; i=i+6) {
            if (number % i == 0 || number % i+2 == 0) return false;
        }
        return true;
    }

}
