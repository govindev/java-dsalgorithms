package com.challenges.leetcode.twentyone.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class DivideTwoIntegers {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dividend : ");
		int dividend = Integer.parseInt(br.readLine());
		System.out.println("Divisor : ");
		int divisor = Integer.parseInt(br.readLine());
		System.out.println(divide(dividend, divisor));
	}

	public static int divide(int dividend, int divisor) {
		int q = 0;
		if (dividend == 0) {
			return 0;
		}
		if (divisor > 0 && dividend > 0) {
            while (dividend - divisor >= 0) {
                dividend = dividend - divisor;
                q++;
                if (dividend == 0) return q;
            }    
            return q;
        } else if (divisor < 0 && dividend < 0) {
            while (dividend - divisor <= 0) {
                dividend = dividend - divisor;
                q++;
                System.out.println(dividend + ", " + q);
                if (dividend == 0) return q;
            }    
            return q;
        } else if (divisor < 0) {
			while (dividend + divisor >= 0) {
				dividend = dividend + divisor;
				q++;
				if (dividend == 0)
					return -q;
			}
			return -q;
		} else {
			return -1;
		}

	}
}
