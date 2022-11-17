package com.miscellaneous;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is valid palindrome" + isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lch = s.charAt(left);
            char rch = s.charAt(right);

            if (!isAlphaNumeric(lch)) {
                left++;
                continue;
            }
            if (!isAlphaNumeric(rch)) {
                right--;
                continue;
            }
            lch = smallCase(lch);
            rch = smallCase(rch);
            if (lch != rch) return false;
            left++;
            right--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char ch) {
        if ((ch >= '0' && ch <= '9') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z'))
            return true;

        return false;
    }

    private static char smallCase(char ch) {
        if ((ch >= '0' && ch <= '9') ||
                (ch >= 'a' && ch <= 'z'))
            return ch;

        return ('A' > 'a') ? (char)(ch+('A'-'a')) : (char)(ch+('a'-'A'));
    }
}
