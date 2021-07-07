package com.leetcode.topinterviewquestions;

import java.util.*;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> spiral = spiralOrder(matrix);
		StringBuilder sb = new StringBuilder();
		for (Integer e : spiral) {
			sb.append(e);
			sb.append("->");
		}
		System.out.println(sb.toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		int ml = matrix.length, nl = matrix[0].length;
		int l = ml * nl;
		int iStart = 0, iEnd = matrix.length - 1, jStart = 0, jEnd = matrix[0].length - 1;

		List<Integer> spiral = new ArrayList<>();
		while (iStart <= iEnd && jStart <= jEnd) {
			int i = iStart;
			int j = jStart;
			while (j <= jEnd) {
				spiral.add(matrix[i][j]);
				if (spiral.size() == l)
					return spiral;
				j++;
			}
			j = jEnd;
			i = iStart + 1;
			while (i <= iEnd) {
				spiral.add(matrix[i][j]);
				if (spiral.size() == l)
					return spiral;
				i++;
			}
			i = iEnd;
			j = jEnd - 1;
			while (j >= jStart) {
				spiral.add(matrix[i][j]);
				if (spiral.size() == l)
					return spiral;
				j--;
			}
			j = jStart;
			i = iEnd - 1;
			while (i > iStart) {
				spiral.add(matrix[i][j]);
				if (spiral.size() == l)
					return spiral;
				i--;
			}

			iStart++;
			jStart++;
			iEnd--;
			jEnd--;
		}
		return spiral;
	}
}
