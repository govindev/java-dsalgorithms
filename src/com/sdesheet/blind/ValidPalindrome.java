package com.sdesheet.blind;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("isPalindrome : " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            char sch = s.charAt(start);
            char ech = s.charAt(end);

            if (!isValidCharOrNum(sch)) {
                start++;
                continue;
            }
            if (!isValidCharOrNum(ech)) {
                end--;
                continue;
            }

            sch = (sch >= 'A' && sch <= 'Z') ? (char) ('a' + sch - 'A') : sch;
            ech = (ech >= 'A' && ech <= 'Z') ? (char) ('a' + ech - 'A') : ech;

            if (sch != ech) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private static boolean isValidCharOrNum(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }
}
