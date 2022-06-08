package com.gfg.dsalgo.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class GreatestCommonDivisor {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("a : ");
		Integer a = Integer.parseInt(br.readLine());
		System.out.println("b : ");
		Integer b = Integer.parseInt(br.readLine());
		System.out.println(gcd2(a, b));
	}

	private static int gcd(int a, int b) {
		// Naive Solution
		int gcd = (a < b) ? a : b;
		while (a % gcd != 0 || b % gcd != 0)
			gcd--;
		return gcd;
	}

	private static int gcd1(int a, int b) {
		// Eucliclean Algorithm
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	private static int gcd2(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd2(b, a % b);
	}
}
