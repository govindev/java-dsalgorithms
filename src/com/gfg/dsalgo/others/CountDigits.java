package com.gfg.dsalgo.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;

/***
 * 
 * @author Govind
 *
 */
public class CountDigits {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number : ");
		int number = Integer.parseInt(inp.readLine());
		int count = 0;
		while (number > 0) {
			count++;
			number = number / 10;
		}
		System.out.println(count);
	}
}
