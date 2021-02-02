package com.gfg.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

public class PalindromeNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer number = Integer.parseInt(br.readLine());
		if (number < 10) {
			System.out.println("Given number is palindrome");
		} else {
			int reverse = 0;
			int old = number;
			while (number > 0) {
				reverse = reverse * 10;
				reverse = reverse + number % 10;
				number = number / 10;
			}
			if (old == reverse) {
				System.out.println("Given number is palindrome");
			} else {
				System.out.println("Given number is not a palindrome");
			}
		}
	}
}
