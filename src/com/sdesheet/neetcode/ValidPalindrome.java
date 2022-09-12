package com.sdesheet.neetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Is Palindrome : " + isPalindrome("0P"));
    }

    public static boolean isNum(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    public static boolean isAsci(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        return false;
    }

    public static char smallcase(char c) {
        if (c >= 'A' && c <= 'Z') return (char) (c + 32);
        return c;
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char lch = smallcase(s.charAt(left));
            char rch = smallcase(s.charAt(right));

            if (!isAsci(lch) && !isNum(lch)) {
                left++;
                continue;
            }
            if (!isAsci(rch) && !isNum(rch)) {
                right--;
                continue;
            }

            if (lch != rch) return false;
            left++;
            right--;
        }
        return true;
    }
}
