package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number : ");
        int enteredNumber = Integer.parseInt(in.readLine());
        int number = enteredNumber;

        // 1. Iterative solution
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        System.out.println("Count of number of digits is : " +  count);

        // 2. Logarithmic solution
        number = enteredNumber;
        System.out.println("Count of number of digits is : " + (Math.floor(Math.log10(number)) + 1) );
    }

}
