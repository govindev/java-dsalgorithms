package com.miscellaneous;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is valid palindrome" + isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left <= right) {
            char ch = s.charAt(left);
            if (!isValid(ch)) {
                left++;
                continue;
            }
            ch = transform(ch);
            char ch2 = s.charAt(right);
            if (!isValid(ch2)) {
                right--;
                continue;
            }
            ch2 = transform(ch2);
            if (ch != ch2) return false;
            left++; right--;
        }
        return true;
    }

    static boolean isValid(char ch) {
        if ((ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }

    static char transform(char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char) (ch + ('a' - 'A'));
        return ch;
    }
}
