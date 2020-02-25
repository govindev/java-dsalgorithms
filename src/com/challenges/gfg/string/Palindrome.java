package com.challenges.gfg.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();
		char[] revArr = new char[length];
		for (int i = 0, j = length - 1; i < str.length(); i++, j--) {
			revArr[j] = str.charAt(i);
		}
		String rev = new String(revArr);
		if (str.equals(rev)) {
			System.out.println("String is a palindrome");
		} else {
			System.out.println("String is not a palindrome");
		}
	}
}
