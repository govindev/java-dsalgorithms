package com.miscellaneous;

public class MinGroupFlips {
    public static void main(String[] args) {
        System.out.println("MinFlips for 00011110001110 : " + findFlips("00011110001110"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("010101100011"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("0"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("01"));
    }

    static int findFlips1(String str) {
        int len = str.length(), zeroGroups = 0, oneGroups = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0 && str.charAt(i) == str.charAt(i-1)) continue;
            if (str.charAt(i) == '0') zeroGroups++;
            else oneGroups++;
        }
        return Math.min(zeroGroups, oneGroups);
    }

    static int findFlips(String str) {
        // Optimal approach
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1)) count++;
        }
        return count/2;
    }
}
