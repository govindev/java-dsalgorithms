package com.challenges.gfg.arrays;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
	https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
	Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
	
	Input:
	The first line contains T, denoting the number of testcases. Then follows description of testcases. Each case begins with a single positive integer N denoting the size of array. The second line contains the N space separated positive integers denoting the elements of array A.
	
	Output:
	For each testcase, print "Yes" or  "No" whether it is Pythagorean Triplet or not (without quotes).
	
	Constraints:
	1 <= T <= 100
	1 <= N <= 107
	1 <= A[i] <= 1000
	
	Example:
	Input:
	1
	5
	3 2 4 6 5
	
	Output:
	Yes
	
	Explanation:
	Testcase 1: a=3, b=4, and c=5 forms a pythagorean triplet, so we print "Yes"
*/
public class PythagoreanTriplet {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			boolean sumFound = false;
			int length = Integer.parseInt(br.readLine());
			String[] a = br.readLine().split(" ");
			for (int k = 0; k < length - 1; k++) {
				for (int l = 1; l < length; l++) {
					int kVal = Integer.parseInt(a[k]) * Integer.parseInt(a[k]);
					int lVal = Integer.parseInt(a[l]) * Integer.parseInt(a[l]);
					int sum = kVal + lVal;
					for (int m = 0; m < length; m++) {
						int mVal = Integer.parseInt(a[m]) * Integer.parseInt(a[m]);
						if (mVal == sum) {
							sumFound = true;
							break;
						}
					}
					if (sumFound)
						break;
				}
				if (sumFound)
					break;
			}
			sb.append((sumFound) ? "Yes\n" : "No\n");
		}
		System.out.println(sb);
	}
}
