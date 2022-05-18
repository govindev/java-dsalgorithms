package com.gfg.dsalgo.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IsPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(in.readLine());

        System.out.println("Is Palindrome : " + isPalindromeWithoutUsingString(number));
    }

    private static boolean checkPalindrome(int number) {
        StringBuilder sb = new StringBuilder("");
        int num = number;
        while(num != 0) {
            sb.append(num % 10);
            num = num / 10;
        }
        return (number == Integer.parseInt(sb.toString()));
    }

    private static boolean isPalindrome(int number) {
        String num = "" + number;

        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeWithoutUsingString(int number) {
        int rev = 0;
        int num = number;
        while (num != 0) {
            rev = rev * 10 + (num % 10);
            num  = num / 10;
        }
        return (number == rev);

    }


}
