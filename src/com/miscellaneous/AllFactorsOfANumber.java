package com.miscellaneous;

public class AllFactorsOfANumber {
    public static void main(String[] args) {
        printFactors(10);
        printFactors(100);
        printFactors(125);
    }

    private static void printFactors(int number) {
        System.out.println("");
        for (int i = 1; i*i <= number; i++) {
            if (number%i == 0) {
                System.out.print(" " + i);
                if (i != number/i)
                    System.out.print(" " + number/i);
            }
        }
    }
}
