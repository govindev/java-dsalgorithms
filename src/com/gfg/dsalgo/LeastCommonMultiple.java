package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class LeastCommonMultiple {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("a : ");
		Integer a = Integer.parseInt(br.readLine());
		System.out.println("b : ");
		Integer b = Integer.parseInt(br.readLine());
		System.out.println(lcm1(a, b));
	}

	private static int lcm(int a, int b) {
		int lcm = (a > b) ? a : b;
		while (true)
			if (lcm % a == 0 && lcm % b == 0)
				return lcm;
			else
				lcm++;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static int lcm1(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
