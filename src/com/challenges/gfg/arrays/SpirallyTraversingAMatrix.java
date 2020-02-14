package com.challenges.gfg.arrays;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
	https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0
	Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.
	
	Input:
	The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.
	
	Output:
	Elements when travelled in Spiral form, will be displayed in a single line.
	
	Constraints:
	1 <= T <= 100
	2 <= M,N <= 10
	0 <= Ai <= 100
	
	Example:
	Input:
	2
	4 4
	1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	3 4
	1 2 3 4 5 6 7 8 9 10 11 12
	
	Output:
	1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
	1 2 3 4 8 12 11 10 9 5 6 7
*/

public class SpirallyTraversingAMatrix {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] lengths = br.readLine().trim().replace(" +", " ").split(" ");
			int rows = Integer.parseInt(lengths[0]);
			int columns = Integer.parseInt(lengths[1]);
			int noOfElements = rows * columns;
			String[] elements = br.readLine().trim().replace(" +", " ").split(" "); // Got the elements
			int countOfElements = 0;
			int colStart = 0, colEnd = columns - 1, rowStart = 0, rowEnd = rows - 1;
			while (countOfElements != noOfElements) {
				int r = rowStart, c = colStart;
				while (r <= rowEnd) {
					if (r > rowStart)
						c = colEnd;
					while (c <= colEnd) {
						sb.append(elements[(r * columns) + c] + " ");
						countOfElements++;
						c++;
					}
					r++;
				}
				r--; c = c - 2;
				while (r > rowStart) {
					if (r < rowEnd) {
						c = colStart;
					}
					while (c >= colStart) {
						sb.append(elements[(r * columns) + c] + " ");
						countOfElements++;
						c--;
					}
					r--;
				}
				colStart++;
				colEnd--;
				rowStart++;
				rowEnd--;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
