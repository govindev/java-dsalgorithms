package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class FibonacciNumber {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(fibonacciNumber(0, 1, n));
	}

	private static int fibonacciNumber(int first, int second, int n) {
		if (n == 0) return first;
		if (n == 1) return second;
		return fibonacciNumber(second, first+second, n-1);
	}
}
