package com.gfg.dsalgo.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class BinaryEquivalentOfDecimal {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		printBinaryEquivalent(n);
	}

	private static void printBinaryEquivalent(int n) {
		if (n == 0) {
			return;
		}
		printBinaryEquivalent(n / 2);
		System.out.print(n % 2);
	}
}
