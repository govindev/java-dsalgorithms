package com.miscellaneous;

public class DigitsOfANumber {
    public static void main(String[] args) {
        printDigitsOfNumber(123);
        countNumberOfDigits(123);
        countNumberOfDigitLogarithmicWay(123);
    }

    private static void printDigitsOfNumber(int number) {
        while (number != 0) {
            System.out.println(number%10);
            number = number/10;
        }
    }

    private static void countNumberOfDigits(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        System.out.println("Number of digits : " + count);
    }

    private static void countNumberOfDigitLogarithmicWay(int number) {
        System.out.println("Number of digits using log function : " + (Math.floor(Math.log10(number))+1));
    }
}
