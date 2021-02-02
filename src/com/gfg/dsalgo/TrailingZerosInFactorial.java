package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class TrailingZerosInFactorial {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		// System.out.println(trailingZeros(factorial(n)));
		System.out.println(countTrailingZeros(n));
	}

	private static int trailingZeros(int n) {
		int count = 0;
		while (n % 10 == 0 && n > 0) {
			count++;
			n = n / 10;
		}
		return count;
	}

	private static int factorial(int n) {
		int fact = 1;
		while (n > 0) {
			fact = fact * n;
			n = n - 1;
		}
		System.out.println(fact);
		return fact;
	}

	static int countTrailingZeros(int n) {
		int res = 0;
		for (int i = 5; i <= n; i = i * 5) {
			res = res + n / i;
		}
		return res;
	}

}
