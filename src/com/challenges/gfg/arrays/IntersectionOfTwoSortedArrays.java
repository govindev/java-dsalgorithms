package com.challenges.gfg.arrays;

public class IntersectionOfTwoSortedArrays {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 3, 3, 5, 7 };
		int b[] = { 2, 3, 4, 7 };
		int i = 0, j = 0;
		int lastElement = -1;
		while(i < a.length && j < b.length) {
			if (a[i] == b[j] && a[i] != lastElement) {
				System.out.println(a[i] + ", ");
				lastElement = a[i];
				i++; j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
			
		}
	}
}
