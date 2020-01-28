package com.dsalgo.recursion;

public class FactorialTailRecursion {

	private static int factorial(int n, int result) {
		if (n == 0)
			return result;
		return factorial(n - 1, n * result);
	}

	private static int factorial(int n) {
		return factorial(n, 1);
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println("Factorial of " + n + " is : " + factorial(n));
	}

}