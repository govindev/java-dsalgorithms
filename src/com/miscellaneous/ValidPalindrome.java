package com.miscellaneous;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is valid palindrome" + isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            char lch = s.charAt(left);
            if (!isValidChar(lch)) {
                left++;
                continue;
            }
            char rch = s.charAt(right);
            if (!isValidChar(rch)) {
                right--;
                continue;
            }
            if (transform(lch) == transform(rch)) {
                left++; right--; continue;
            }
            return false;
        }
        return true;
    }

    private static char transform(char ch) {
        if ((ch >= '0' && ch <= '9')
                || (ch >= 'a' && ch <= 'z'))
            return ch;
        return (char) (ch+('a'-'A'));
    }

    private static boolean isValidChar(char ch) {
        if ((ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
}
