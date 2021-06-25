package com.challenges.gfg.arrays;

public class UnionOfTwoSortedArrays {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 3, 3, 5, 7 };
		int b[] = { 2, 3, 4, 7 };
		int i = 0, j = 0;

		while (i < a.length && j < b.length) {
			if (i - 1 >= 0 && a[i] == a[i - 1]) {
				i++;
			} else if (j - 1 >= 0 && b[j] == b[j - 1]) {
				j++;
			} else if (a[i] < b[j]) {
				System.out.println(a[i] + ",");
				i++;
			} else if (a[i] > b[j]) {
				System.out.println(b[j] + ",");
				j++;
			} else {
				System.out.println(a[i] + ",");
				i++;
				j++;
			}
		}
		while (i < a.length) {
			if (i - 1 >= 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			System.out.println(a[i] + ",");
			i++;
		}
		while (j < b.length) {
			if (j - 1 >= 0 && b[j] == b[j - 1]) {
				j++;
				continue;
			}
			System.out.println(b[j] + ",");
			j++;
		}
	}
}
