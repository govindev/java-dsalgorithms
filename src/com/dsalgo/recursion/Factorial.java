package com.dsalgo.recursion;

public class Factorial {

	private static int factorial(int i) {
		// Recursive solution
		if (i == 0)
			return 1;
		return (i) * factorial(i - 1);
	}

	public static void main(String[] args) {
		int i = 5;
		System.out.println(" Factorial of " + i + " is : " + factorial1(i));
	}

	private static int factorial1(int n) {
		int fact = 1;
		// Iterative solution
		for (int i = n; i >= 2; i--) {
			fact = fact * i;
		}
		return fact;
	}

}