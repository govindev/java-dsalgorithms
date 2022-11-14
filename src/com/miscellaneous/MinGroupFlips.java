package com.miscellaneous;

public class MinGroupFlips {
    public static void main(String[] args) {
        System.out.println("MinFlips for 00011110001110 : " + findFlips("00011110001110"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("010101100011"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("0"));
        System.out.println("MinFlips for 010101100011 : " + findFlips("01"));
    }
    static int findFlips(String str) {
        int count =  1, n = str.length();
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) != str.charAt(i-1)) {
                count++;
            }
        }
        return count/2;
    }
}
