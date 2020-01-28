package com.dsalgo.recursion;

public class Factorial {

	private static int factorial(int i) {
		if (i == 0)
			return 1;
		return (i) * factorial(i - 1);
	}

	public static void main(String[] args) {
		int i = 12;
		System.out.println(" Factorial of " + i + " is : " + factorial(i));
	}
	
}