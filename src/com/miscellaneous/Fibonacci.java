package com.miscellaneous;

public class Fibonacci {
    public static void main(String[] args) {
        printFibonaci(10);
    }

    private static void printFibonaci(int max) {
        int a = 0, b = 1;
        System.out.print("0, 1, ");
        for (int i = 0; i < max; i++) {
            int c = a+b;
            System.out.print(c + ", ");
            a = b;
            b = c;
        }
    }
}
