package com.gfg.dsalgo;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckBitSet {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int k = Integer.parseInt(br.readLine().trim());
		System.out.println(isBitSet1(n, k));
	}

	private static boolean isBitSet(int n, int k) {
		// using the right shift
		if (((n >> (k - 1)) & 1) == 1) {
			return true;
		}
		return false;
	}

	private static boolean isBitSet1(int n, int k) {
		// Using the left shift
		if (((1 << (k - 1)) & n) > 0) {
			return true;
		}
		return false;
	}
}
