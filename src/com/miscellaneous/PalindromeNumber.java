package com.miscellaneous;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0, temp = x;
        while (temp > 0) {
            rev *= 10;
            rev += temp%10;
            temp /= 10;
        }
        return (x == rev);
    }
}
