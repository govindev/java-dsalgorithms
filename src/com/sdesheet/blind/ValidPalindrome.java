package com.sdesheet.blind;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println("isPalindrome : " + validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftCh = s.charAt(left);
            if (!isAlphanumeric(leftCh)) {
                left++;
                continue;
            }
            char rightCh = s.charAt(right);
            if (!isAlphanumeric(rightCh)) {
                right--;
                continue;
            }
            if (!areSame(leftCh, rightCh)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean areSame(char a, char b) {
        if (a == b) {
            return true;
        }
        if (isNumeric(a)) {
            return false;
        }
        char smallA = isSmallCase(a) ? a : smallcase(a);
        char smallB = isSmallCase(b) ? b : smallcase(b);
        return (smallA == smallB);
    }

    private char smallcase(char ch) {
        return (char)(ch-'A'+'a');
    }

    private boolean isNumeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private boolean isSmallCase(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isUpperCase(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private boolean isAlphanumeric(char ch) {
        return isNumeric(ch) || isSmallCase(ch) || isUpperCase(ch);
    }
}
