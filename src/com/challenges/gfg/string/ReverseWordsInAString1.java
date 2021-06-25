package com.challenges.gfg.string;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseWordsInAString1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpStrs = br.readLine().trim().split("\\.");
		StringBuilder revString = new StringBuilder();
		for (int i = inpStrs.length - 1; i >= 0; i--) {
			revString.append(inpStrs[i]);
			if (i != 0) {
				revString.append(".");
			}
		}
		System.out.println(revString.toString());
	}
}
