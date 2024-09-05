package com.sdesheet.blind;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println("isPalindrome : " + validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && right > 0) {
            if (isNotAAlphaNumeric(s.charAt(left))) {
                left++;
            }
            else if (isNotAAlphaNumeric(s.charAt(right))) {
                right--;
            }
            else if (getSmallCase(s.charAt(left)) != getSmallCase(s.charAt(right))) {
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isNotAAlphaNumeric(char ch) {
        boolean isAlphaNumeric =
                (isNumber(ch) || isSmallCase(ch) || isUpperCase(ch));
        return !isAlphaNumeric;
    }

    private char getSmallCase(char ch) {
        if (isNumber(ch) || isSmallCase(ch)) return ch;
        return (char) ('a' + (ch - 'A'));
    }

    private boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private boolean isSmallCase(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isUpperCase(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }
}
