package com.interviews;

import java.util.Arrays;

public class OrderArraysForMinimumSum {

	public static void main(String[] args) {
		int a[] = { 1, 3, 8, 5 };
		int b[] = { 2, 8, 9, 6 };
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * b[i];
		}
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder("Array a : [");
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] / b[i];
			sb.append(a[i] + ", ");
		}
		sb.append("]");
		System.out.println(sb);

	}
}