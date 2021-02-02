package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

/**
 * 
 * @author Govind
 *
 */
public class FactorialOfANumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		System.out.println(factorial1(n));
	}

	private static int factorial(int n) {
		// Auxillary space is theta of n because of the function call stack. Not
		// recommended
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	private static int factorial1(int n) {
		int fact = 1;
		while (n > 0) {
			fact = fact * n;
			n = n - 1;
		}
		return fact;
	}
}
